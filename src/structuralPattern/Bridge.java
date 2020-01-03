package structuralPattern;

abstract class BridgePublication {
    private Publication publication;

    public BridgePublication(Publication publication) {
        this.publication = publication;
    }

    public Publication getPublication() {
        return publication;
    }
}

abstract class Publication {
    private BridgePublication bridgePublication;

    public BridgePublication getBridgePublication() {
        return bridgePublication;
    }

    public void setBridgePublication(BridgePublication bridgePublication) {
        this.bridgePublication = bridgePublication;
    }
}

class BookImpl extends Publication {
    private String title;
    private String author;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class Book extends BridgePublication {
    public Book(String title, String author) {
        super(new BookImpl());
        ((BookImpl)getPublication()).setTitle(title);
        ((BookImpl)getPublication()).setAuthor(author);
    }

    @Override
    public String toString() {
        return ((BookImpl)getPublication()).getTitle() + " de " +
        ((BookImpl)getPublication()).getAuthor();
    }
}

class Bridge {
    public static void main(String[] args) {
        new Bridge().publish();
    }

    public void publish() {
//        BookImpl book = new BookImpl();
//        book.setAuthor("GoF");
//        book.setTitle("Design Patterns");
//        System.out.println(book.getTitle() + " - " + book.getAuthor());

        Book book = new Book("Design Patterns", "GoF");
        System.out.println(book);
    }
}
