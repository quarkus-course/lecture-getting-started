package tech.donau.course;

import tech.donau.course.data.Book;
import tech.donau.course.service.BookService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

@Path("/book")
public class BookResource {

    @Inject
    BookService bookService;

    private static ArrayList<Book> books = new ArrayList<>();

    static {
        books.add(new Book("The Freelancer's bible", "IDK"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Book> getBooks() {
        return books;
//        return Response.ok(books).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(Book book) {
        bookService.checkBook(book);
        if (books.size() > 5) {
            return Response.status(400).entity("No more than 5 books allowed").build();
        }
        books.add(book);
        return Response.ok(book).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book updateBook(@PathParam("id") Integer index, Book book) {
        books.remove((int) index);
        books.add(index, book);
        return book;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book deleteBook(@PathParam("id") Integer index) {
        return books.remove((int) index);
    }
}
