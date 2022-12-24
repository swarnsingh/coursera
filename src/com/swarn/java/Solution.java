package com.swarn.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author Swarn Singh.
 */
public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int k = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        String result = Result.solve(k, numbers);
//        System.out.println(result);
//
////        bufferedWriter.write(result);
////        bufferedWriter.newLine();
////
//          bufferedReader.close();
////        bufferedWriter.close();
//    }
//}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int nameCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> name = IntStream.range(0, nameCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int priceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> price = IntStream.range(0, priceCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int weightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> weight = IntStream.range(0, weightCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.numDuplicates(name, price, weight);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}

class Products {
    String name;
    Integer price;
    Integer Weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return Weight;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(name, products.name) &&
                Objects.equals(price, products.price) &&
                Objects.equals(Weight, products.Weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, Weight);
    }
}

class Result {

    public static int numDuplicates(List<String> name, List<Integer> price, List<Integer> weight) {
        LinkedHashSet<Products> set = new LinkedHashSet<>(name.size());
        int count = 0;
        for (int i = 0; i < name.size(); i++) {
            Products product = new Products();
            product.setName(name.get(i));
            product.setPrice(price.get(i));
            product.setWeight(weight.get(i));

            boolean isAdded = set.add(product);

            if (!isAdded) {
                count++;
            }
        }
        return count;
    }

    public static String solve(int k, List<Integer> numbers) {

        int l = k - 1;
        int m = 0;
        int size = numbers.size();
        if ((size >= 1 && size <= 100000) && (k >= 1 && k <= size)) {
            if (numbers.size() % k == 0) {
                for (int i = 0; i < numbers.size() / k; i++) {
                    Set<Integer> set = new HashSet<>(k);
                    for (int j = m; j <= l; j++) {
                        boolean isAdded = set.add(numbers.get(j));
                        if (!isAdded) {
                            return "No";
                        }
                    }
                    m = l + 1;
                    l = l + k;
                }
            } else {
                return "No";
            }
        } else {
            return "No";
        }
        return "Yes";
    }
}
