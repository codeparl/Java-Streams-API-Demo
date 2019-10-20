/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastrams;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author HASSAN
 */
public class Java8Strams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//      MList<String>  word =  new MList<>("Java","C++","Collections","Map");
//
//      word.addElement("Computer").addElement("Japan").addElement("Kenya");
//      
//      
//      word.forEach((t) -> {
//          System.out.println("Word:: "+t);
//      });
//      
//      
//        System.out.println("findMacth::\n");

//  System.out.println("Original values:\n");      
//  ArrayList<Integer>  list  =  new ArrayList<>();
// for(int i = 0; i < 20; ++i){
//     list.add((int) (new Random().nextInt(100)));
//     
//     
//     System.out.println("Value: "+list.get(i));
// }
//        System.out.println("-----------------------------------------------\n");      
// 
 
 
      //  createStream(list);
      mapStreams();
 
    }
    
    
    private static void longWordCounter() throws IOException{
    
        Stream<String>  words  =  Stream.of("welcome to java programming".split("\\PL+"));
       words.forEach((t) -> {System.out.println("wordx:: "+t);});
       
       words  =  Stream.of("welcome to java programming".split("\\PL+"));
       words  =  words.map(String::toUpperCase);
    
       words.forEach((t) -> {System.out.println("wordx:: "+t);});
       
        //System.out.println("exist: "+new File("Frame.txt").exists());
     String content  = new String(
             Files.readAllBytes(
             Paths.get("Frame.txt")),StandardCharsets.UTF_8);
   
    List<String>  wordList =  Arrays.asList(content.split("\\PL+"));
     long count = 0;
//    for(String x  : wordList)
//       if(x.length() >= 12 ){
//           ++count;
//           System.out.println("Word:: "+x);
//            }
//    
//        
      count  =  wordList.stream().filter(x -> x.length() >= 12).count();
System.out.print("long words: "+count);
   wordList.clear();

    }


private static void findMacth(Collection<String>  list){
//create a stream from this list.
Stream<String>  stream =  list.stream();

Optional<String>  match  =  stream.filter(s -> s.matches("java")).findAny();
    System.out.println("match is:  "+match.orElse("No match"));
 
}    

static void createStream(Collection<Integer>  list){

    Stream<Integer>  stm  =  list.stream();
    
  //use optional to compute min and max 
  Optional<Integer>  min  =  stm.min(Integer::compare );
  if(min.isPresent())System.out.println("Minimum Value is: "+min.get());
 
//obtain max 
stm  =  list.stream();
Optional<Integer> max  =  stm.max(Integer::compare);
if(max.isPresent())System.out.println("And Max value is: "+max.get());

  Stream<Integer>  sorted  =  list.stream().sorted();
    System.out.println("\nAfter sorting the stream:");
  sorted.forEach((t) -> {System.out.println("Value: "+t.intValue());});
    
    System.out.println("Only Even Values:\n"); 
    Stream <Integer> even  =  list.stream().filter((n) -> n % 2 == 0 );
    even.forEach((t) -> {System.out.println("Value: "+t);});
  
    Stream<Integer> middle  =  list.stream().filter((t) -> t > list.stream().min(Integer::compare).get() 
                                 && t < list.stream().max(Integer::compare).get());
 
    System.out.println("Filter middle Values:\n"); 
  middle.forEach((t) -> {System.out.println("value: "+t);});
  
  System.out.println("Filter odd Values:\n");
  middle  =  list.stream()
          .filter((t) -> t > list.stream().min(Integer::compare).get() 
                                 && t < list.stream().max(Integer::compare).get())
          .filter((n) -> n % 2 == 1 );
 
middle.forEach((t) -> {System.out.println("value: "+t);});
  
 System.out.println("Filter prime Values:\n"); 
 middle  =  list.stream().filter((Integer f) -> {
     int d =2;
     while(++d < f)if(f % d  == 0 )return   false;
     return true;
    });
 
 middle.forEach((t) -> {System.out.println("value: "+t);});
 
  System.out.println("Reduced to product:\n"); 
 Optional<Integer>  product =  list.stream().reduce((x, y) -> x*y);
 if(product.isPresent())System.out.println("The product is: "+product.get());
 
   System.out.println("Reduced to total:\n"); 
 Optional<Integer>  sum  =  list.stream().reduce((x,y) -> x+y);
 if(product.isPresent())System.out.println("The total is: "+sum.get());
 
   System.out.println("Reduced to product2:\n"); 
 int prod  =  list.stream().reduce(0,(x,y) -> x+y);
   System.out.println("The total is: "+prod);
   
    System.out.println("parallelStream::\n");
  
   
}//end method 
 

private static void parallelStream(){
ArrayList<Double> list =  new ArrayList<>();

list.add(34.0);
list.add(27.0);
list.add(67.0);
list.add(17.0);
list.add(45.0);
list.add(16.0);

Stream<Double>  allMatch  =  list.stream().distinct();
    System.out.println("allMatch:: \n");
    allMatch.forEach((t) -> {
        System.out.println("  "+t);
    });

double product  =  list.parallelStream().reduce(1.0, (a,b) -> a * b, (a,b) -> a * b);
double normal  =  list.stream().reduce(1.0,(x,y) -> x *y);


System.out.println("Sequencial:  "+normal);

System.out.println("product:  "+product);


double rootProduct  =  list.parallelStream().reduce(1.0, (a , b) -> a * b, (a,b)-> a * Math.sqrt(b));
    
 System.out.println("rootProduct:  "+rootProduct);  
 
    System.out.println("\nManipulating Maps with streams methods\n"
            + "---------------------------------------------------------\n");
    System.out.println("Original Collection:");   
 List<Book>  books =  buyBooks();
 books.forEach((t) -> {System.out.println(t);});
 
    System.out.println("Sorted by title:");
    Stream<Book>  bookStream =  books.stream().sorted((o1, o2) -> o1.title.compareTo(o2.title));
 
   bookStream.forEach((t) -> {System.out.println(t);});
 
    System.out.println("Compound Sort:\n"
            + "---------------------------------------\n");
 Stream<Book>  compoundSort =  books.stream()
         .sorted((o1, o2) -> o1.title.compareTo(o2.title))
         .sorted((o1, o2) -> o1.author.compareTo(o2.author));
 
  System.out.println("Sorted by title then author:");
 compoundSort.forEach((t) -> {System.out.println(t);});

 System.out.println("Mapping books  and their authors :\n"
         + "------------------------------------------------\n");
 
 Stream<AuthorAndTitle> mapped  =  books.stream()
         .map((a) -> new AuthorAndTitle(a.author, a.title,a.bookId, a.price));
 mapped.forEach((t) -> {System.out.println(t);});
 
 System.out.println("\nMapping  books  and their authors with price <= 70:\n"
         + "----------------------------------------------------------------\n");
  Stream<AuthorAndTitle> mappedCheaper  =  books.stream()
          .filter((a) -> a.price <= 70.0)
          .map((a) -> new AuthorAndTitle(a.author, a.title,a.bookId,a.price));
          
  
 mappedCheaper.forEach((t) -> {System.out.println(t);});
 
  System.out.println("\nTurning a stream into a collection\n"
         + "----------------------------------------------------------------\n");
  
  Stream<AuthorAndTitle> authorAndTitle  =  books.stream()
         .map((a) -> new AuthorAndTitle(a.author, a.title,a.bookId, a.price));
  List<AuthorAndTitle>  bookList  =  authorAndTitle.collect(Collectors.toList());
  
    System.out.printf("%-9s%-39s%-25s%s%n%s%n","BookID","Title","Author","Price",
    "_____________________________________________________________________________________");
  for(AuthorAndTitle b : bookList){
        System.out.printf("%-9d%-39s%-25s%.2f%n",
                b.getBookId(),b.getTitle(),b.getAuthor(),b.getPrice());
        System.out.println("_____________________________________________________________________________________");
  }
  
    System.out.println("\n\nUsing spliterator to print book details\n"
            + "------------------------------------------------------------------------------\n");
    
     List<Book>  books2 =  buyBooks();
    Spliterator<Book>  spliterator =  books2.spliterator();
    
    while( spliterator.tryAdvance((x)-> System.out.println(x)) );
    
    
    
 
    System.out.println("\n");
}//endnmethod 

static void mapStreams(){
parallelStream(); 

}

private static ArrayList<Book> buyBooks(){

    ArrayList<Book>   books =  new ArrayList<>();
    
    books.add(new Book("Core Java", "Cay S. Horstmann", "Prentice Hall", 25, 8));
    books.add(new Book("The Hidden Scretes", "Hassan Mugabo", "Zinc Publichers", 100, 1));
    books.add(new Book("Java the complete referene ", "Oracle", "Prentice Hall", 50, 9));
    books.add(new Book("Think Python", "John Smith", "O,Reilly", 45, 2));
    books.add(new Book("Java How to program early Objects", "Paul Deteil", "Prentice Hall", 70, 10));
    
    
    
return books;
}

    private static void printAllPrimes(){
    
     List<Integer>  nums  =  new ArrayList<>();
    for(int i = 0; i <= 50; ++i) {   
        nums.add(i);
    
    }
    Stream<Integer>  s  = nums.stream().filter(x -> isPrime(50));
 
    
    
    }
    
    
    public  static  class MList<T> extends  ArrayList<T>{
   
    
        public MList() {
            super();
        }

        public MList(Collection<? extends T> c) {
            super(c);
          }

        public MList(T...element) {
            
           for(T x : element)
               add(x);
        }//end constructor 

     public  MList<T> addElement(T e){
         this.add(e);
     
     return this;
     }
    
        
        
    
    
    
    }
    
    
    static class Book implements  Serializable, Cloneable{
    
     private String title;
     private String author;
     private String publisher;
     private double price;
     private int edition;
     private long bookId = 1;
     private static long bookCounter;
     private transient static final String  format = 
                      "ID#: %d%n"
                     +"    Book Tile    : %s%n"
                    + "    Author       : %s%n"
                    + "    publisher    : %s%n"
                    + "    Edition      : %d%n"
                     +"    Price        : $%.2f%n";
                    

        public Book(String title, String author, String publisher, double price, int edition) {
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.price = price;
            this.edition = edition;
            bookId += bookCounter++;
            
            
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setEdition(int edition) {
            this.edition = edition;
        }

        public String getPublisher() {
            return publisher;
        }

        public double getPrice() {
            return price;
        }

        public int getEdition() {
            return edition;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            
            Book  cloned  =  (Book) super.clone();
           return cloned; 
        }

        @Override
        public boolean equals(Object obj) {
            
          if(obj == null) return false;
          if(this.getClass() == obj.getClass()) return true;
          if(this  == obj) return  true;
          
          Book   other  =  (Book) obj;
          if(other.getTitle().equals(title) && 
                  other.author.equals(author)&& 
                  other.getPublisher().equals(publisher) && 
                  other.getEdition() == edition && other.price ==  price)return true;
            
            return false; 
        }

        @Override
        public int hashCode() {
            
            
            
            return 17 * Objects.hash(author, edition,price,publisher,title);
        }

        @Override
        public String toString() {
            return String.format(format, bookId,title, author, publisher, edition, price);
        }
     
     
        
    
    
    }
    
    static boolean  isPrime(int n){
      int d  = 2;
      while(d <= n){
        if(n % d ==0)
            return false;
        ++d;
      }
     return true; 
    }
    
    
}
