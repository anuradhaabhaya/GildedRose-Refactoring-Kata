package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Nested
    class SellIn {
        @ParameterizedTest
        @ValueSource(strings = {"Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Any other item except Sulfuras"})
        void sellInDecreasesForAnyItemExceptSulfuras(String itemName) {
            // Arrange
            Item[] items = new Item[]{new Item( itemName, 1, 0 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).name ).isEqualTo( itemName );
            assertThat( app.items.get(0).sellIn ).isEqualTo( 0 );
        }

        @Test
        void sellInDoesNotDecreasesForSulfuras() {
            // Arrange
            Item[] items = new Item[]{new Item( "Sulfuras, Hand of Ragnaros", 0, 0 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).name ).isEqualTo( "Sulfuras, Hand of Ragnaros" );
            assertThat( app.items.get(0).sellIn ).isEqualTo( 0 );
        }
    }

    @Nested
    class Quality {
        @Test
        void agedBrieQualityIncreases() {
            // Arrange
            Item[] items = new Item[]{new Item( "Aged Brie", 1, 0 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).name).isEqualTo( "Aged Brie" );
            assertThat( app.items.get(0).quality).isEqualTo( 1 );
        }

        @Test
        void qualityDoesNotExceed50() {
            // Arrange
            Item[] items = new Item[]{new Item( "Aged Brie", 1, 50 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).quality ).isEqualTo( 50 );
        }

        @Test
        void qualityIsNeverNegative() {
            // Arrange
            Item[] items = new Item[]{new Item( "Other item", 1, 0 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).quality ).isEqualTo( 0 );
        }

        @Test
        void sulfurasQualityDoesNotChange() {
            // Arrange
            Item[] items = new Item[]{new Item( "Sulfuras, Hand of Ragnaros", 0, 80 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).quality ).isEqualTo( 80 );
        }

        @Test
        void conjuredItemQualityDecreasesTwiceAsFastAsABasicItem() {
            // Arrange
            Item[] items = new Item[]{new Item( "Conjured", 1, 10 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).quality ).isEqualTo( 8 );
        }
    }

    @Nested
    class SellInAndQuality {
        @Test
        void qualityDecresesTwiceAsFastWhenSellInIsNegative() {
            // Arrange
            Item[] items = new Item[]{new Item( "Not special item", 0, 10 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).sellIn ).isEqualTo( -1 );
            assertThat( app.items.get(0).quality ).isEqualTo( 8 );
        }

        @Test
        void backstageQualityIncreasesBy1WhenSellIsSuperiorTo10() {
            // Arrange
            Item[] items = new Item[]{new Item( "Backstage passes to a TAFKAL80ETC concert", 11, 10 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).quality).isEqualTo( 11 );
        }

        @ParameterizedTest
        @ValueSource(ints = {10, 9, 8, 7, 6})
        void backstageQualityIncreasesBy2WhenSellInBetween10And5(int sellIn) {
            // Arrange
            Item[] items = new Item[]{new Item( "Backstage passes to a TAFKAL80ETC concert", sellIn, 10 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).quality).isEqualTo( 12 );
        }

        @ParameterizedTest
        @ValueSource(ints = {5, 4, 3, 2, 1})
        void backstageQualityIncreasesBy3WhenSellInBetween5And0(int sellIn) {
            // Arrange
            Item[] items = new Item[]{new Item( "Backstage passes to a TAFKAL80ETC concert", sellIn, 10 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).quality).isEqualTo( 13 );
        }

        @Test
        void backstageQualityIs0WhenSellIs0() {
            // Arrange
            Item[] items = new Item[]{new Item( "Backstage passes to a TAFKAL80ETC concert", 0, 10 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).quality).isEqualTo( 0 );
        }

        @Test
        void conjuredQualityDecresesFourTimesAsFastWhenSellInIsNegative() {
            // Arrange
            Item[] items = new Item[]{new Item( "Conjured", 0, 10 )};
            GildedRose app = new GildedRose( items );

            // Act
            app.updateQuality();

            // Assert
            assertThat( app.items.get(0).sellIn ).isEqualTo( -1 );
            assertThat( app.items.get(0).quality ).isEqualTo( 6 );
        }
    }

}
