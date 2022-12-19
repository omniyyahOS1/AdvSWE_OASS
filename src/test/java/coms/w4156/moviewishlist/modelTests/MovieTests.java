package coms.w4156.moviewishlist.modelTests;

import coms.w4156.moviewishlist.models.Movie;
import coms.w4156.moviewishlist.models.Wishlist;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieTests {

    @Test
    void testEquals() {
        Wishlist wishlist1 = new Wishlist();
        Wishlist wishlist2 = new Wishlist();
        List<Wishlist> wishlists = List.of(wishlist1, wishlist2);

        List<String> genres = List.of("Sci-Fi", "Action");

        Movie matrix = new Movie(
            42L,
            wishlists,
            "The Matrix",
            genres,
            1999,
            144,
            100
        );
        Movie matrix2 = new Movie(
            42L,
            wishlists,
            "The Matrix",
            genres,
            1999,
            144,
            100
        );

        Assertions.assertEquals(matrix, matrix2);
    }

    @Test
    void testNotEquals() {
        Wishlist wishlist1 = new Wishlist();
        Wishlist wishlist2 = new Wishlist();
        List<Wishlist> wishlists = List.of(wishlist1, wishlist2);

        List<String> genres = List.of("Sci-Fi", "Action");

        Movie matrix = new Movie(
            42L,
            wishlists,
            "The Matrix",
            genres,
            1999,
            144,
            100
        );
        Movie matrix2 = new Movie(
            43L,
            wishlists,
            "The Matrix",
            genres,
            1999,
            144,
            100
        );

        Assertions.assertNotEquals(matrix, matrix2);
    }

    @Test
    void testBigConstructorNullWishlist() {
        Wishlist wishlist1 = new Wishlist();
        Wishlist wishlist2 = new Wishlist();
        List<Wishlist> wishlists = List.of(wishlist1, wishlist2);

        List<String> genres = List.of("Sci-Fi", "Action");

        Movie matrix = new Movie(
            42L,
            List.of(),
            "The Matrix",
            genres,
            1999,
            144,
            100
        );
        Movie matrix2 = new Movie(
            42L,
            null,
            "The Matrix",
            genres,
            1999,
            144,
            100
        );

        Assertions.assertEquals(matrix, matrix2);
    }

    @Test
    void testGetWishlists() {
        Wishlist wishlist1 = new Wishlist();
        Wishlist wishlist2 = new Wishlist();
        List<Wishlist> wishlists = List.of(wishlist1, wishlist2);

        List<String> genres = List.of("Sci-Fi", "Action");

        Movie matrix = new Movie(
            42L,
            wishlists,
            "The Matrix",
            genres,
            1999,
            144,
            100
        );

        Assertions.assertEquals(wishlists, matrix.getWishlists());
    }

    @Test
    void testGetWishlistsNull() {
        Movie matrix = new Movie();
        matrix.setWishlists(null);

        Assertions.assertEquals(List.of(), matrix.getWishlists());
    }

    @Test
    void testGetRatings() {
        Movie matrix = new Movie();

        Assertions.assertEquals(null, matrix.getRatings());
    }

    @Test
    void testSetWishlists() {
        Wishlist wishlist1 = new Wishlist();
        Wishlist wishlist2 = new Wishlist();
        List<Wishlist> wishlists = List.of(wishlist1, wishlist2);

        Movie matrix = new Movie();
        matrix.setWishlists(wishlists);

        Assertions.assertEquals(wishlists, matrix.getWishlists());
    }
}
