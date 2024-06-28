package com.swarn.interview.phonepe;


import java.util.Stack;

import static com.swarn.interview.opentext.FormatStrings.solution;

/**
 * For inputString = "(bar)", the output should be
 * solution(inputString) = "rab";
 * For inputString = "foo(bar)baz", the output should be
 * solution(inputString) = "foorabbaz";
 * For inputString = "foo(bar)baz(blim)", the output should be
 * solution(inputString) = "foorabbazmilb";
 * For inputString = "foo(bar(baz))blim", the output should be
 * solution(inputString) = "foobazrabblim".
 * Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
 *
 * I/P -> (bar)  O/P -> rab
 * I/P -> foo(bar)baz  O/P -> foorabbaz
 * I/P -> foo(bar)baz(blim)  O/P -> foorabbazmilb
 * I/P -> foo(bar(baz))blim O/P -> foobazrabblim
 *
 */
class Pair<T1, T2> {

    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }
}
public class ReverseNestedParantheses {

    public static void main(String[] args) {
        System.out.println(solution("foo(bar)baz(blim)"));
    }

}

