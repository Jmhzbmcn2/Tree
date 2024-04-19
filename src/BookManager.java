package demo.mid.bookmanager;

import java.util.*;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        bookList = new LinkedList<>();
    }

    public List<Book> getBookList() {
        /* TODO */
        return bookList;
    }
	
	/**
	Lưu ý  
	Lưu ý
	Lưu ý : Có 2 hàm không giống bài của th lâm nhưng tương tự , bạn xẩu nhé !!!!!!!!!!!!!!!!!!!!!
	Lưu ý
	Lưu ý
	*/
	

    /**
     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     * @param index
     * @param limit
     * @return
     */
    private boolean checkBoundaries(int index, int limit) {
        /* TODO */
        return index >= 0 && index <= limit;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        /* TODO */
        if (book != null) {
            bookList.add(book);
        }
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size()) && book != null) {
            bookList.add(index, book);
        } else {
            System.out.println("Can't add book at index " + index + "!");
        }

    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size() - 1)) {
            bookList.remove(index);
        } else {
            System.out.println("Can't remove book at index " + index + "!");
        }

    }

    /**
     * Bỏ book như tham số truyền vào.
     * @param book
     */
    public void remove(Book book) {
        /* TODO */
        bookList.remove(book);


    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        return checkBoundaries(index, bookList.size() - 1) ? bookList.get(index) : null;

    }

    /**
     * Sắp xếp danh sách book theo thứ tự tăng dần theo genre và sau đó đến title.
     * @return
     */
    public List<Book> sortIncreasingByGenreAndTitle() {
        /* TODO */
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                int genreComparison = book1.getGenre().compareTo(book2.getGenre());
                if (genreComparison != 0) {
                    return genreComparison;
                }
                return book1.getTitle().compareTo(book2.getTitle());
            }
        });
        return newList;

    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo genre tăng dần, nếu genre như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortIncreasingGenreAndPrice() {
        /* TODO */
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                int genreComparison = book1.getGenre().compareTo(book2.getGenre());
                if (genreComparison != 0) {
                    return genreComparison;
                }
                return Double.compare(book2.getPrice(), book1.getPrice());
            }
        });

        return newList;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo genre giảm dần, nếu genre như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortDecreasingGenreAndPrice() {
        /* TODO */
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                int genreComparison = book2.getGenre().compareTo(book1.getGenre());
                if (genreComparison != 0) {
                    return genreComparison;
                }
                return Double.compare(book2.getPrice(), book1.getPrice());
            }
        });

        return newList;
    }

    /**
     * Sắp xếp sách theo giá tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        /* TODO */
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return Double.compare(book1.getPrice(), book2.getPrice());
            }
        });

        return newList;
    }

    /**
     * Sắp xếp sách theo giá giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        /* TODO */
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return Double.compare(book2.getPrice(), book1.getPrice());
            }
        });

        return newList;
    }

    /**
     * Sắp xếp sách theo số trang tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPages() {
        /* TODO */
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return Integer.compare(book1.getPages(), book2.getPages());
            }
        });

        return newList;
    }

    /**
     * Sắp xếp sách theo số trang giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPages() {
        /* TODO */
        List<Book> newList = new LinkedList<>(this.bookList);
        Collections.sort(newList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return Integer.compare(book2.getPages(), book1.getPages());
            }
        });

        return newList;
    }

    /**
     * Lọc ra howMany sách có số trang lớn nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterHighestPages(int howMany) {
        /* TODO */
        List<Book> books = sortDecreasingPages();
        return books.subList(0, Math.min(howMany, books.size()));

    }

    /**
     * Lọc ra những sách có số trang cao hơn lowerBound.
     * @param lowerBound
     * @return
     */
    public List<Book> filterBooksPagesHigherThan(double lowerBound) {
        /* TODO */
        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getPages() > lowerBound) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterBookLowestPages(int howMany) {
        /* TODO */
        List<Book> books = sortIncreasingPages();
        return books.subList(0, Math.min(howMany, books.size()));

    }

    /**
     * Lọc ra howMany sách có số trang nhỏ hơn upperBound.
     * @param upperBound
     * @return
     */
    public List<Book> filterBooksPagesLowerThan(double upperBound) {
        /* TODO */
        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getPages() < upperBound) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        /* TODO */
        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getPublisher().equals(publisher)) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    /**
     * Lọc ra những sách theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        /* TODO */
        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getGenre().equals(genre)) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    /**
     * Lọc ra những sách theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        /* TODO */
        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getAuthor().equals(author)) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
