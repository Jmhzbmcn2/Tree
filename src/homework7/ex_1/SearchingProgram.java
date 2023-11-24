package homework7.ex_1;

public class SearchingProgram {
    public void search(int value){
        SearchingAdministration administration = new SearchingAdministration();
        administration.initData(100);
        administration.intList();
        System.out.println("Search Using UnsortedArray");
        administration.searchElement("unsortedArray", value);
        System.out.println("Search Using SortedArray");
        administration.searchElement("sortedArray", value);
        System.out.println("Search Using UnsortedLinkedList");
        administration.searchElement("unsortedLinkedList", value);
        System.out.println("Search Using SortedLinkedList");
        administration.searchElement("sortedLinkedList", value);
    }
}
