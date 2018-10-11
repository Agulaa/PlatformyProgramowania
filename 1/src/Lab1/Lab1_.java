package Lab1;

import sun.security.x509.AttributeNameEnumeration;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lab1_ {

    public static  void main(String[] arg){
        System.out.println("Hello World!");

            zad4_2();

    }

    public static void zad1(){
        Scanner read = new Scanner(System.in);
        System.out.println("Podaj n: ");
        int n = read.nextInt();
        read.close();

        //TABLICA
        long startTime = System.nanoTime();
        int [] tab = new int[n];
        for(int i=0;i<n;i++){
            tab[i] = i;
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("int [n]: " + estimatedTime + " ns");

        // arrayList
        startTime = System.nanoTime();
        ArrayList array1 = new ArrayList<Integer>();

        for(int i=0;i<n;i++){
            array1.add(n);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("arraylist: " + estimatedTime + " ns");

        startTime = System.nanoTime();
        ArrayList array2 = new ArrayList<Integer>(n);
        for(int i=0;i<n;i++){
            array2.add(n);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("arraylist[n]: " + estimatedTime + " ns");

        startTime = System.nanoTime();
        LinkedList linked = new LinkedList<Integer>();
        for(int i = 0;i<n;i++){
            linked.add(n);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedlist: " + estimatedTime + " ns");
    }
    private static BigInteger silnia(int n){
        BigInteger result = new BigInteger("1");
        for(int i = 1; i<=n;i++)
        {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void zad2(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Podaj n: ");
        int n = reader.nextInt();
        reader.close();
        long startTime = System.nanoTime();
        BigInteger silnia = silnia(n);
        long estimatedTime = System.nanoTime() - startTime;

        System.out.println("Silnia dla n = " + n + " wynosi: " +silnia +
                " czas potrzebny na obliczenie: "+ estimatedTime + "ns");
    }

    public static void zad3() throws IOException {

       String path = "C://AGA//PlatformyProgramowania//src//Lab1//macbeth.txt";
       Stream<String> stream = Files.lines(Paths.get(path));
       List<String> list = new ArrayList<>();

       list = stream.map(String::toLowerCase).collect(Collectors.toList());

        ArrayList<String> list2 = new ArrayList<>();
        String[] data;
       for(int i=0; i<list.size(); i++){
           data = list.get(i).split("\\W");
           for(int j=0; j<data.length; j++){
               if(data[j].length()>3){
                   list2.add(data[j]);
               }
           }
       }
//        for(int i=0; i<list2.size(); i++){
//           System.out.println(list2.get(i));
//        }
        List<String> distinctWord = list2.stream().distinct().collect(Collectors.toList());
        for(int i=0; i<distinctWord .size(); i++){
            System.out.println(distinctWord .get(i));
        }
        System.out.println(distinctWord.size());

    }

    public static void zad3_1() throws IOException {
        String path = "C://AGA//PlatformyProgramowania//src//Lab1//macbeth.txt";
        Stream<String> stream = Files.lines(Paths.get(path));
        List<String> list = new ArrayList<>();
        list = stream.map(String::toLowerCase).collect(Collectors.toList());
        String[] data;
        List<String> output = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            data = list.get(i).split("\\W+");
            for(int j=0; j<data.length; j++){
                if(data[j].length()>=3){
                    output.add(data[j]);
                }
            }
        }
        output.stream().distinct().collect(Collectors.toList());
        for(int i=0; i<output.size(); i++){
            System.out.println(output.get(i));
        }
        System.out.println(output.size());

    }
    public static void merge(int pocz, int sr, int kon){
        int i = pocz;
        int m = sr+1;
        int j = kon;

    }
    public static ArrayList<Integer> insertSort1(ArrayList<Integer> list){
        int pom, j;
        for(int i=1; i<list.size(); i++){
            pom = list.get(i);
            for(j=i-1; j>=0 && pom<list.get(j); j--){
                list.set(j+1, list.get(j));
            }
            list.set(j+1, pom); // j+1, bo wychodząc z pętli j zmniejszane jest o jeden, i tutaj odbywa się "swap"
                                // i z pom, bo to była ta nasza wartość obserwowana na samym początku
        }
        return list;

    }
    public static ArrayList<Integer> insertSort2(ArrayList<Integer> list){
        int pom, j;
        for(int i=1; i<list.size(); i++){
            pom = list.get(i);
            for(j=i-1; j>=0 && pom>list.get(j); j--){
                list.set(j+1, list.get(j));
            }
            list.set(j+1, pom);
        }
        return list;

    }
    public static void zad4_1(){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,3,20,6,10,0,8,4,2,1,4));

        long startTime = System.nanoTime();
        ArrayList<Integer> sortlist_ros = insertSort1(list);
        long estimatedTime = System.nanoTime() - startTime;
        for (Integer x : sortlist_ros ){
            System.out.print(x);
            System.out.print(",");
        }
//        for(int i=0; i<sortlist_ros.size(); i++){
//            System.out.print(sortlist_ros.get(i));
//        }
        System.out.println();
        System.out.println(estimatedTime);
        long startTime2 = System.nanoTime();
        ArrayList<Integer> sortlist_mal = insertSort2(list);
        long estimatedTime2 = System.nanoTime() - startTime2;

        for (Integer x : sortlist_mal ){
            System.out.print(x);
            System.out.print(",");
        }
        System.out.println();
        System.out.println(estimatedTime2);
    }
    public static void doMergeSort(int[] array, int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(array, lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(array, middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(array, lowerIndex, middle, higherIndex);
        }
    }

    public static void mergeParts(int[] array, int lowerIndex, int middle, int higherIndex) {
        int[] tempMergArr = new int[array.length];
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
    public static void zad4_2() {
        int[] list = {1, 2, 5, 4, 3, 7, 89, 9, 5};

        long startTime = System.nanoTime();
        doMergeSort(list, 0, list.length);
        long estimatedTime = System.nanoTime() - startTime;
        for (Integer x : list) {
            System.out.print(x);
            System.out.print(",");

        }


    }
}
