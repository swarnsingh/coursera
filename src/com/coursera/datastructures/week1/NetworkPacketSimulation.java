package com.coursera.datastructures.week1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem Description
 * <p>
 * Task.
 * You are given a series of incoming network packets, and your task is to simulate their processing. Packets
 * arrive in some order. For each packet number 𝑖, you know the time when it arrived 𝐴𝑖 and the time it takes the
 * processor to process it 𝑃𝑖 (both in milliseconds). There is only one processor, and it processes the incoming
 * packets in the order of their arrival. If the processor started to process some packet, it doesn’t interrupt or stop
 * until it finishes the processing of this packet, and the processing of packet 𝑖 takes exactly 𝑃𝑖 milliseconds.
 * <p>
 * The computer processing the packets has a network buffer of fixed size 𝑆. When packets arrive, they are stored in the
 * buffer before being processed. However, if the buffer is full when a packet arrives (there are 𝑆 packets which have
 * arrived before this packet, and the computer hasn’t finished processing any of them), it is dropped and won’t be
 * processed at all. If several packets arrive at the same time, they are first all stored in the buffer (some of them
 * may be dropped because of that — those which are described later in the input). The computer processes the packets
 * in the order of their arrival, and it starts processing the next available packet from the buffer as soon as it
 * finishes processing the previous one. If at some point the computer is not busy, and there are no packets in the
 * buffer, the computer just waits for the next packet to arrive. Note that a packet leaves the buffer and frees the
 * space in the buffer as soon as the computer finishes processing it.
 * <p>
 * Input Format. The first line of the input contains the size 𝑆 of the buffer and the number 𝑛 of incoming network
 * packets. Each of the next 𝑛 lines contains two numbers. 𝑖-th line contains the time of arrival 𝐴𝑖 and the processing
 * time 𝑃𝑖 (both in milliseconds) of the 𝑖-th packet. It is guaranteed that the sequence of arrival times is
 * non-decreasing (however, it can contain the exact same times of arrival in milliseconds — in this case the packet
 * which is earlier in the input is considered to have arrived earlier).
 * <p>
 * Output Format. For each packet output either the moment of time (in milliseconds) when the processor began processing
 * it or −1 if the packet was dropped (output the answers for the packets in the same order as the packets are given in
 * the input).
 * <p>
 * Sample 1.
 * <p>
 * Input:
 * <p>
 * 1 1
 * 0 0
 * Output:
 * <p>
 * 0
 * Explanation: The only packet arrived at time 0, and computer started processing it immediately.
 * <p>
 * Sample 3.
 * <p>
 * Input:
 * <p>
 * 1 2
 * 0 1
 * 0 1
 * Output:
 * <p>
 * 0
 * -1
 * Explanation: The first packet arrived at time 0, the second packet also arrived at time 0, but was dropped, because
 * the network buffer has size 1 and it was full with the first packet already. The first packet started processing at
 * time 0, and the second packet was not processed at all.
 * <p>
 * Sample 4.
 * <p>
 * Input:
 * <p>
 * 1 2
 * 0 1
 * 1 1
 * Output:
 * <p>
 * 0
 * 1
 * Explanation: The first packet arrived at time 0, the computer started processing it immediately and finished at
 * time 1. The second packet arrived at time 1, and the computer started processing it immediately.
 * <p>
 * To solve this problem, you can use a list or a queue (in this case the queue should allow accessing its last element,
 * and such queue is usually called a deque). You can use the corresponding built-in data structure in your language of
 * choice.
 * <p>
 * One possible solution is to store in the list or queue finish_time the times when the computer will finish processing
 * the packets which are currently stored in the network buffer, in increasing order. When a new packet arrives, you
 * will first need to pop from the front of finish_time all the packets which are already processed by the time new
 * packet arrives. Then you try to add the finish time for the new packet in finish_time. If the buffer is full (there
 * are already 𝑆 finish times in finish_time), the packet is dropped. Otherwise, its processing finish time is added to
 * finish_time.
 * <p>
 * If finish_time is empty when a new packet arrives, computer will start processing the new packet immediately as soon
 * as it arrives. Otherwise, computer will start processing the new packet as soon as it finishes to process the last of
 * the packets currently in finish_time (here is when you need to access the last element of finish_time to determine
 * when the computer will start to process the new packet). You will also need to compute the processing finish time by
 * adding 𝑃𝑖 to the processing start time and push it to the back of finish_time.
 * <p>
 * You need to remember to output the processing start time for each packet instead of the processing finish time which
 * you store in finish_time.
 * <p>
 * Solution:
 * To solve this problem, we need to notice at some points:
 * <p>
 * We just need to keep track of finishing time.
 * The current time processing is the time each request comes in. At each time request arrived, we should remove all
 * request has done in finish_time queue.
 * Always queue new request when finish_time is empty.
 */

/**
 * @author Swarn Singh.
 */
public class NetworkPacketSimulation {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int buffer_max_size = scanner.nextInt();
        Buffer buffer = new Buffer(buffer_max_size);

        ArrayList<Request> requests = readQueries(scanner);
        ArrayList<Response> responses = processRequests(requests, buffer);
        printResponses(responses);
    }

    private static ArrayList<Request> readQueries(Scanner scanner) throws IOException {
        int requests_count = scanner.nextInt();
        ArrayList<Request> requests = new ArrayList<>();
        for (int i = 0; i < requests_count; ++i) {
            int arrival_time = scanner.nextInt();
            int process_time = scanner.nextInt();
            requests.add(new Request(arrival_time, process_time));
        }
        return requests;
    }

    private static ArrayList<Response> processRequests(ArrayList<Request> requests, Buffer buffer) {
        ArrayList<Response> responses = new ArrayList<>();
        for (int i = 0; i < requests.size(); ++i) {
            responses.add(buffer.Process(requests.get(i)));
        }
        return responses;
    }

    private static void printResponses(ArrayList<Response> responses) {
        for (int i = 0; i < responses.size(); ++i) {
            Response response = responses.get(i);
            if (response.dropped) {
                System.out.println(-1);
            } else {
                System.out.println(response.start_time);
            }
        }
    }
}

class Request {
    public Request(int arrival_time, int process_time) {
        this.arrival_time = arrival_time;
        this.process_time = process_time;
    }

    public int arrival_time;
    public int process_time;
}

class Response {
    public Response(boolean dropped, int start_time) {
        this.dropped = dropped;
        this.start_time = start_time;
    }

    public boolean dropped;
    public int start_time;
}

class Buffer {
    public Buffer(int size) {
        this.size_ = size;
        this.finish_time_ = new ArrayList<>();
    }

    public Response Process(Request request) {

        while (!finish_time_.isEmpty()) {
            if (finish_time_.get(0) <= request.arrival_time)
                finish_time_.remove(0);
            else
                break;
        }

        if (finish_time_.size() == size_) {
            return new Response(true, -1);
        }
        if (finish_time_.isEmpty()) {
            finish_time_.add(request.arrival_time + request.process_time);
            return new Response(false, request.arrival_time);
        }

        int lastElement = finish_time_.get(finish_time_.size() - 1);
        finish_time_.add(lastElement + request.process_time);
        return new Response(false, lastElement);
    }

    private int size_;
    private ArrayList<Integer> finish_time_;
}