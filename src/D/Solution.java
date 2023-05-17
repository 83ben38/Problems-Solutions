package D;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static Integer maximum_depth(Pipe root_pipe) {
        return 1 + root_pipe.getMaxDepth();
    }
    public static Pipe getNode(int nodeId, HashMap<Integer, Pipe> pipes) {
        if (pipes.containsKey(nodeId)) {
            return pipes.get(nodeId);
        }
        Pipe new_pipe = new Pipe(nodeId);
        pipes.put(nodeId, new_pipe);
        return new_pipe;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Pipe root = null;
        HashMap<Integer,Pipe> h = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Pipe p = getNode(s.nextInt(),h);
            if (root == null){
                root = p;
            }
            int c = s.nextInt();
            for (int j = 0; j < c; j++) {
                p.children.add(getNode(s.nextInt(),h));
                p.pipeLengths.add(s.nextInt());
            }
        }
        System.out.println(maximum_depth(root));
    }
}

class Pipe{
    public int id;
    public ArrayList<Pipe> children = new ArrayList<>();
    public ArrayList<Integer> pipeLengths = new ArrayList<>();

    public int maxDepth = -1;
    public Pipe(int id){
        this.id = id;
    }

    public int getMaxDepth(){
        if (maxDepth != -1){
            return maxDepth;
        }
        int max = 0;
        for (Pipe child: children) {
            if (child.getMaxDepth() + pipeLengths.get(children.indexOf(child)) > max){
                max=child.getMaxDepth() + pipeLengths.get(children.indexOf(child));
            }
        }
        maxDepth = max;
        return max;
    }
}