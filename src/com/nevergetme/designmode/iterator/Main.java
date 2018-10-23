package com.nevergetme.designmode.iterator;

/***
 * 将遍历与实现分离
 */
public class Main {
    public static void main(String[] args){
        BookShelf bookShelf=new BookShelf(4);
        bookShelf.appendBook(new Book("the beauty"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Java"));
        bookShelf.appendBook(new Book("Python"));
        Iterator it=bookShelf.iterator();
        while(it.hasNext()){
            Book book=(Book)it.next();
            System.out.println(book.getName());
        }
    }
}
