import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class btpreorder {
    static class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class binaarytree{
        static int idx=-1;
        public static node buildtree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            node newnode =new node(nodes[idx]);
           newnode.left= buildtree(nodes);
           newnode.right=buildtree(nodes);
           return newnode;

        }
    }
    public static void preorder(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    public static void postorder(node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }
    public static void levelorder(node root){
        Queue <node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            node currnode=q.remove();
            if(currnode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }else{
                System.out.print(currnode.data);
                if(currnode.left!=null){
                    q.add(currnode.left);
                }
                if(currnode.right!=null){
                    q.add(currnode.right);
                    
                }
            }
        }
    }
    public static int countOfnode(node root){
        if(root==null){
            return 0;
        }
        int leftnode=countOfnode(root.left);
        int rightnode=countOfnode(root.right);
        return leftnode+rightnode+1;
    }
    public static int sumOfnode(node root){
        if(root==null){
            return 0;
        }
        int leftsum=sumOfnode(root.left);
        int rightsum=sumOfnode(root.right);
        return leftsum+rightsum+root.data;
    }
    public static int height(node root){
        if (root==null){
            return 0;
        }
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        int myheight=Math.max(leftheight, rightheight)+1;
        return myheight;
    }
    public static int diameter(node root){
        int leftdiam=diameter(root.left);
        int rightdiam=diameter(root.right);
        int diam3=height(root.left)+height(root.right)+1;
        return Math.max(diam3,Math.max(rightdiam, leftdiam));
    }
    public static class treeinfo{
        int ht;
        int diam;
        treeinfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;

        }
    }
    public static treeinfo diameter2(node root){
        if(root==null){
          return  new treeinfo(0, 0);
        }
        treeinfo left=diameter2(root.left);
        treeinfo right=diameter2( root.right);
        int myheights=Math.max(left.ht, right.ht)+1;
        int diam1=left.diam;
        int diam2=right.diam;
        int diam3=left.ht+right.ht+1;
        int mydiam=Math.max(Math.max(diam1, diam2), diam3);
        treeinfo myinfo= new treeinfo(myheights, mydiam);
        return myinfo;

    }
    public boolean isidentical(TreeNode root,TreeNode subroot){
        if(root==null && subroot==null){}
            return true;
    }
        if(root==null||subroot==null){
            return false;
        }
        if(root.val ==subroot.val){
            return isidentical(root.left, subroot.left)
        }
    }
    public boolean issubtree(TreeNode root,TreeNode subroot){
        if(subroot==null){
            return true;
        }
        if (root==null){
            return false;
        }
        if(root.val==subroot.val){
            if(isidentical(root.subroot)){
                return true;
            }
        }
      return  issubtree((root.left), subroot)||issubtree(root.right, subroot);
    }

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,3,-1,6,-1,-1,-1};
        binaarytree tree=new binaarytree();
        node root=tree.buildtree(nodes);
        System.out.println(root.data);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        levelorder(root);
        countOfnode(root);
       System.out.println(sumOfnode(root));
       System.out.println(height(root));
       System.out.println(diameter2(root).diam);

    }
}
