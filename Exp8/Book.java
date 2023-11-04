public class Book {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.display();
        Reference_Book r1 = new Reference_Book();
        r1.display();
        Magazine m1 = new Magazine();
        m1.display();
    }

    public void display() {
        String name = "Fundamentals of Electrical Engineering";
        String author = "Charles A. Gross";
        int volume = 1;
        System.out.println("Book Title: " + name + ", Author: " + author + ", Volume: " + volume);
    }
}

class Reference_Book extends Book {
    @Override
    public void display() {
        String name = "Advanced Semiconductor Fundamentals";
        String author = "Robert F. Pierret";
        int volume = 2;
        System.out.println("Book Title: " + name + ", Author: " + author + ", Volume: " + volume);
    }
}

class Magazine extends Book {
    @Override
    public void display() {
        String name = "IEEE Spectrum";
        String author = "IEEE";
        int volume = 2023;
        System.out.println("Magazine Title: " + name + ", Publisher: " + author + ", Issue: " + volume);
    }
}
