package views;

import javax.swing.*;
import javax.swing.tree.*;

import java.awt.*;
import java.io.*;

public class SimpleTree extends JPanel {
	private JTree fileTree;
	private FileSystemModel fileSystemModel;
	
	
	public SimpleTree() {
		fileSystemModel = new FileSystemModel(new File(System.getProperty("user.dir")));
		fileTree = new JTree(fileSystemModel);
		fileTree.setEditable(false);//to edit names in tree
		setLayout(new BorderLayout());
		add(new JScrollPane((JTree)fileTree),"Center");
		fileTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		/*root = new DefaultMutableTreeNode("root", true);
		getList(root, new File(System.getProperty("user.dir")+"/data/"));
		setLayout(new BorderLayout());
		tree = new JTree(root);
		tree.setRootVisible(false);
		add(new JScrollPane((JTree)tree),"Center");
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);*/

    //Listen for when the selection changes.
    //tree.addTreeSelectionListener(this);
	}
  
  public Dimension getPreferredSize(){
    return new Dimension(50, 30);
    }
  
 /* public void getList(DefaultMutableTreeNode node, File f) {
     if(!f.isDirectory()) {
    	 //esto es para tener como archivo solo los que dicen .java 
         // We keep only JAVA source file for display in this HowTo
         if (f.getName().endsWith("bin")) {
            //System.out.println("FILE  -  " + f.getName());
        	 DefaultMutableTreeNode child = new DefaultMutableTreeNode(f.getName());
             node.add(child);
            }
         //DefaultMutableTreeNode child = new DefaultMutableTreeNode(f.getName());
         //node.add(child);
         }
     else {
         //System.out.println("DIRECTORY  -  " + f.getName());
         DefaultMutableTreeNode child = new DefaultMutableTreeNode(f.getName());
         node.add(child);
         File fList[] = f.listFiles();
         for(int i = 0; i  < fList.length; i++)
             getList(child, fList[i]);
         }
    }

  	public void valueChanged(TreeSelectionEvent e) {
	//Returns the last path element of the selection.
	//This method is useful only when the selection model allows a single selection.
	    DefaultMutableTreeNode node = (DefaultMutableTreeNode)fileTree.getLastSelectedPathComponent();

	    if (node == null)
	    //Nothing is selected.     
	    return;

	    Object nodeInfo = node.getUserObject();
	    if (node.isLeaf()) {
	        //BookInfo book = (BookInfo)nodeInfo;
	        //displayURL(book.bookURL);
	    	System.out.println(node.toString());
	    } else {
	        //displayURL(helpURL);
	    	System.out.println(node.toString());
	    }
	}*/
  	
  	public void revalidate(){
  		removeAll();
  		fileSystemModel = new FileSystemModel(new File(System.getProperty("user.dir")));
		fileTree = new JTree(fileSystemModel);
		fileTree.setEditable(false);//to edit names in tree
		setLayout(new BorderLayout());
		add(new JScrollPane((JTree)fileTree),"Center");
		fileTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		super.revalidate();
  	}
  	
  	public JTree getTree(){
  		return fileTree;
  	}
  }