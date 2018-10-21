package Laboratorium_1_08_10;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Laboratorium_1 {

    public static void main(String[] arg){
        //zad1();
        //zad2();
        //zad3();

        zad4_1();
        zad4_2();

    }

    public static void zad1(){
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbe n");
        int n = in.nextInt();

        //TABLICE
        long startTime = System.nanoTime();
        int[] tab = new int[n];
        for(int i=0; i<n; i++) {
            tab[i]=i;
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Czas tworzenia i uzupełniania tablic ="+estimatedTime+"ns");

        //ARRAYLIST
        long startTime2 = System.nanoTime();
        ArrayList<Integer> arreyList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arreyList.add(i);
        }
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("Czas tworzenia i uzupełniania ArrayList ="+estimatedTime2+"ns");

        //ARRAY LIST Z N
        long startTime3 = System.nanoTime();

        ArrayList<Integer> arreyList2 = new ArrayList<>(n);
        System.out.println(arreyList2.size());
        for(int i=0; i<n; i++) {
            arreyList2.add(i);
        }
        System.out.println(arreyList2.size());
        long estimatedTime3 = System.nanoTime() - startTime3;
        System.out.println("Czas tworzenia i uzupełniania ArrayList z N ="+estimatedTime3+"ns");

        //LINKEDLIST
        long startTime4 = System.nanoTime();
        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0; i<n; i++) {
            list.add(i);
        }
        long estimatedTime4 = System.nanoTime() - startTime4;
        System.out.println("Czas tworzenia i uzupełniania LinkedList ="+estimatedTime4+"ns");
    }

    private static BigInteger silnia(int n){
        BigInteger result = new BigInteger("1");
        for(int i=2; i<=n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;

    }
    public static void zad2(){
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbe n");
        int n = in.nextInt();
        long startTime = System.nanoTime();
        BigInteger result = silnia(n);
        long estimatedTime = System.nanoTime() - startTime;

        System.out.println("Wynik: "+String.format("%e", new BigDecimal(result.toString()))+" czas:"+estimatedTime+"ns");
    }

    public static void zad3(){
        String path = "C://AGA//PlatformyProgramowania//src//Laboratorium_1_08_10//macbeth.txt";
        List<String> list;
        String line;
        String[] token;
        ArrayList<String> allTokens = new ArrayList<>();
        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            list = stream.map(String::toLowerCase).collect(Collectors.toList());
            for(int i=0; i<list.size(); i++){
                line = list.get(i);
                token = line.split("\\W+");
                for(int j=0; j<token.length; j++){
                    if(token[j].length()>=3){
                        allTokens.add(token[j]);
                    }
                }
            }
            List<String> result = allTokens.stream().distinct().collect(Collectors.toList());
            for( String r : result){
                System.out.println(r);
            }
            System.out.println(result.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int[] insertion_ros(int[] tab){
        int pom, j;
        for(int i=1; i<tab.length; i++){
            pom = tab[i];
            for(j=i-1; j>=0 && pom<tab[j]; j--){
                tab[j+1]=tab[j];
            }
            tab[j+1]=pom;
        }
        return tab;

    }
    public static int[] insertion_mal(int[] tab){
        int pom, j;
        for(int i=1; i<tab.length; i++){
            pom = tab[i];
            for(j=i-1; j>=0 && pom>tab[j]; j--){
                tab[j+1]=tab[j];
            }
            tab[j+1]=pom;
        }
        return tab;

    }
    public static void zad4_1(){
        int n = 100;
        int[] tab = new int[n];
        Random rand = new Random();
        for(int i=0; i<n; i++){
            tab[i]= rand.nextInt();
        }
        long startTime = System.nanoTime();
        int[] sortTab_ros = insertion_ros(tab);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Czas ros: " + estimatedTime);
//        for(int x : sortTab_ros){
//            System.out.print(x);
//            System.out.print(",");
//        }
        System.out.println();
        long startTime1 = System.nanoTime();
        int[] sortTab_mal = insertion_mal(tab);
        long estimatedTime2 = System.nanoTime() - startTime1;
        System.out.println("Czas mal: " + estimatedTime2);
//        for(int x : sortTab_mal){
//            System.out.print(x);
//            System.out.print(",");
//        }
    }
    public static int[] mergeSort(int[] input) {
        if (input.length < 2) {
            return input;
        }
        int mid = input.length / 2;
        int[] left = Arrays.copyOfRange(input, 0, mid);
        int[] right = Arrays.copyOfRange(input, mid, input.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] output = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                output[k++] = left[i++];
            } else {
                output[k++] = right[j++];
            }
        }
        while (i < left.length) {
            output[k++] = left[i++];
        }
        while (j < right.length) {
            output[k++] = right[j++];
        }
        return output;
    }
    public static void zad4_2(){
        int n = 100;
        int[] tab = new int[n];
        Random rand = new Random();
        for(int i=0; i<n; i++){
            tab[i]= rand.nextInt();
        }
        long startTime1 = System.nanoTime();
        int[] result = mergeSort(tab);
        long estimatedTime2 = System.nanoTime() - startTime1;
        System.out.println("Czas: "+ estimatedTime2);
//        for(int x : result){
//            System.out.print(x);
//            System.out.print(",");
//        }
    }
}
