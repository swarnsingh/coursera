package com.swarn.coursera.datastructures.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Problem Description
 * <p>
 * Task.
 * Your friend is making a text editor for programmers. He is currently working on a feature that will
 * find errors in the usage of different types of brackets. Code can contain any brackets from the set []{}(),
 * where the opening brackets are [,{, and ( and the closing brackets corresponding to them are ],}, and ).
 * For convenience, the text editor should not only inform the user that there is an error in the usage of brackets,
 * but also point to the exact place in the code with the problematic bracket. First priority is to find the first
 * unmatched closing bracket which either doesn’t have an opening bracket before it, like ] in ](), or closes the
 * wrong opening bracket, like } in ()[}. If there are no such mistakes, then it should find the first unmatched
 * opening bracket without the corresponding closing bracket after it, like ( in {}([]. If there are no mistakes,
 * text editor should inform the user that the usage of brackets is correct.
 * <p>
 * Apart from the brackets, code can contain big and small latin letters, digits and punctuation marks.
 * More formally, all brackets in the code should be divided into pairs of matching brackets, such that in each pair
 * the opening bracket goes before the closing bracket, and for any two pairs of brackets either one of them is nested
 * inside another one as in (foo[bar]) or they are separate as in f(a,b)-g[c]. The bracket [ corresponds to the
 * bracket ], { corresponds to }, and ( corresponds to ).
 * <p>
 * Input Format.
 * Input contains one string 𝑆 which consists of big and small latin letters, digits, punctuation marks
 * and brackets from the set []{}().
 * <p>
 * Constraints.
 * The length of 𝑆 is at least 1 and at most 10^5.
 * <p>
 * Output Format.
 * If the code in 𝑆 uses brackets correctly, output “Success" (without the quotes).
 * Otherwise, output
 * the 1-based index of the first unmatched closing bracket, and if there are no unmatched closing brackets, output
 * the 1-based index of the first unmatched opening bracket.
 */

/**
 * @author Swarn Singh.
 */
public class CheckBrackets {

    private static class Bracket {
        char type;
        int position;

        Bracket(char type, int position) {
            this.type = type;
            this.position = position;
        }

        boolean isMatch(char c) {
            if (this.type == '[' && c == ']')
                return true;
            if (this.type == '{' && c == '}')
                return true;
            return this.type == '(' && c == ')';
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> stack = new Stack<>();
        stack.peek();
        boolean isSuccess = true;
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                if (position != text.length() - 1) {
                    Bracket openingBracket = new Bracket(next, position);
                    stack.push(openingBracket);
                } else {
                    System.out.println(++position);
                    isSuccess = false;
                    break;
                }
            }

            if (next == ')' || next == ']' || next == '}') {
                Bracket item = stack.pop();
                if (!item.isMatch(next)) {
                    System.out.println(++position);
                    isSuccess = false;
                    break;
                }
            }
        }

        if (isSuccess) {
            System.out.println("Success");
        }
    }
}
