import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.v4.gui.SystemFontMetrics;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class Test {
    public static void main(String[] args) throws Exception{
        //prepare token stream
        CharStream stream = new ANTLRInputStream("class BinaryTree{\n" +
                "    public static void main(String[] a){\n" +
                "    System.out.println(new BT().Start());\n" +
                "\t\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "// This class invokes the methods to create a tree,\n" +
                "// insert, delete and serach for  elements on it\n" +
                "class BT {\n" +
                "\n" +
                "    public int Start(){\n" +
                "    Tree root ;\n" +
                "    boolean ntb ;\n" +
                "    int nti ;\n" +
                "\n" +
                "    root = new Tree();\n" +
                "    ntb = root.Init(16);\n" +
                "    ntb = root.Print();\n" +
                "    System.out.println(100000000);\n" +
                "    ntb = root.Insert(8) ;\n" +
                "    ntb = root.Print();\n" +
                "    ntb = root.Insert(24) ;\n" +
                "    ntb = root.Insert(4) ;\n" +
                "    ntb = root.Insert(12) ;\n" +
                "    ntb = root.Insert(20) ;\n" +
                "    ntb = root.Insert(28 && 5) ;\n" +
                "    ntb = root.Insert(14) ;\n" +
                "    ntb = root.Print();\n" +
                "    System.out.println(root.Search(24));\n" +
                "    System.out.println(root.Search(12));\n" +
                "    System.out.println(root.Search(16));\n" +
                "    System.out.println(root.Search(50));\n" +
                "    System.out.println(root.Search(12));\n" +
                "    ntb = root.Delete(12);\n" +
                "    ntb = root.Print();\n" +
                "    System.out.println(root.Search(12));\n" +
                "\n" +
                "    return 0 ;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "class Tree{\n" +
                "    Tree left ;\n" +
                "    Tree right;\n" +
                "    int key ;\n" +
                "    boolean has_left ;\n" +
                "    boolean has_right ;\n" +
                "    Tree my_null ;\n" +
                "\n" +
                "    // Initialize a node with a key value and no children\n" +
                "    public boolean Init(int v_key){\n" +
                "    key = v_key ;\n" +
                "\tkey = \"fs\";\n" +
                "    has_left = false ;\n" +
                "    has_right = false ;\n" +
                "    return true ;\n" +
                "    }\n" +
                "\n" +
                "    // Update the right child with rn\n" +
                "    public boolean SetRight(Tree rn){\n" +
                "    right = rn ;\n" +
                "    return true ;\n" +
                "    }\n" +
                "    \n" +
                "    // Update the left child with ln\n" +
                "    public boolean SetLeft(Tree ln){\n" +
                "    left = ln ;\n" +
                "    return true ;\n" +
                "    }\n" +
                "\n" +
                "    public Tree GetRight(){\n" +
                "    return right ;\n" +
                "    }\n" +
                "\n" +
                "    public Tree GetLeft(){\n" +
                "    return left;\n" +
                "    }\n" +
                "\n" +
                "    public int GetKey(){\n" +
                "    return key ;\n" +
                "    }\n" +
                "\n" +
                "    public boolean SetKey(int v_key){\n" +
                "    key = v_key ;\n" +
                "    return true ;\n" +
                "    }\n" +
                "\n" +
                "    public boolean GetHas_Right(){\n" +
                "    return has_right ;\n" +
                "    }\n" +
                "\n" +
                "    public boolean GetHas_Left(){\n" +
                "    return has_left ;\n" +
                "    }\n" +
                "\n" +
                "    public boolean SetHas_Left(boolean val){\n" +
                "     has_left = val ;\n" +
                "     return true ;\n" +
                "    }\n" +
                "\n" +
                "    public boolean SetHas_Right(boolean val){\n" +
                "     has_right = val ;\n" +
                "     return true ;\n" +
                "    }\n" +
                "    \n" +
                "    // This method compares two integers and\n" +
                "    // returns true if they are equal and false\n" +
                "    // otherwise\n" +
                "    public boolean Compare(int num1 , int num2){\n" +
                "    boolean ntb ;\n" +
                "    int nti ;\n" +
                "\n" +
                "    ntb = false ;\n" +
                "    nti = num2 + 1 ;\n" +
                "    if (num1 < num2) ntb = false ;\n" +
                "    else if (!(num1 < nti)) ntb = false ;\n" +
                "    else ntb = true ;\n" +
                "    return ntb ;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    // Insert a new element in the tree\n" +
                "    public boolean Insert(int v_key){\n" +
                "    Tree new_node ;\n" +
                "    boolean ntb ;\n" +
                "    boolean cont ;\n" +
                "    int key_aux ;\n" +
                "    Tree current_node ;\n" +
                "\n" +
                "    new_node = new Tree();\n" +
                "    ntb = new_node.Init(v_key) ;\n" +
                "    current_node = this ;\n" +
                "    cont = true ;\n" +
                "    while (cont){\n" +
                "        key_aux = current_node.GetKey();\n" +
                "        if (v_key < key_aux){\n" +
                "        if (current_node.GetHas_Left())\n" +
                "            current_node = current_node.GetLeft() ;\n" +
                "        else {\n" +
                "            cont = false ;\n" +
                "            ntb = current_node.SetHas_Left(true);\n" +
                "            ntb = current_node.SetLeft(new_node);\n" +
                "        }\n" +
                "        }\n" +
                "        else{\n" +
                "        if (current_node.GetHas_Right())\n" +
                "            current_node = current_node.GetRight() ;\n" +
                "        else {\n" +
                "            cont = false ;\n" +
                "            ntb = current_node.SetHas_Right(true);\n" +
                "            ntb = current_node.SetRight(new_node);\n" +
                "        }\n" +
                "        }\n" +
                "    }\n" +
                "    return true ;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    // Delete an element from the tree\n" +
                "    public boolean Delete(int v_key){\n" +
                "    Tree current_node ;\n" +
                "    Tree parent_node ;\n" +
                "    boolean cont ;\n" +
                "    boolean found ;\n" +
                "    boolean is_root ;\n" +
                "    int key_aux ;\n" +
                "    boolean ntb ;\n" +
                "\n" +
                "    current_node = this ;\n" +
                "    parent_node = this ;\n" +
                "    cont = true ;\n" +
                "    found = false ;\n" +
                "    is_root = true ;\n" +
                "    while (cont){\n" +
                "        key_aux = current_node.GetKey();\n" +
                "        if (v_key < key_aux)\n" +
                "        if (current_node.GetHas_Left()){\n" +
                "            parent_node = current_node ;\n" +
                "            current_node = current_node.GetLeft() ;\n" +
                "        }\n" +
                "        else cont = false ;\n" +
                "        else \n" +
                "        if (key_aux < v_key)\n" +
                "            if (current_node.GetHas_Right()){\n" +
                "            parent_node = current_node ;\n" +
                "            current_node = current_node.GetRight() ;\n" +
                "            }\n" +
                "            else cont = false ;\n" +
                "        else { \n" +
                "            if (is_root) \n" +
                "            if ((!current_node.GetHas_Right()) && \n" +
                "                (!current_node.GetHas_Left()) )\n" +
                "                ntb = true ;\n" +
                "            else \n" +
                "                ntb = this.Remove(parent_node,current_node); \n" +
                "            else ntb = this.Remove(parent_node,current_node);\n" +
                "            found = true ;\n" +
                "            cont = false ;\n" +
                "        }\n" +
                "        is_root = false ;\n" +
                "    }\n" +
                "    return found ;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    // Check if the element to be removed will use the\n" +
                "    // righ or left subtree if one exists\n" +
                "    public boolean Remove(Tree p_node, Tree c_node){\n" +
                "    boolean ntb ;\n" +
                "    int auxkey1 ;\n" +
                "    int auxkey2 ;\n" +
                "    \n" +
                "    if (c_node.GetHas_Left()) \n" +
                "        ntb = this.RemoveLeft(p_node,c_node) ;\n" +
                "    else \n" +
                "        if (c_node.GetHas_Right())\n" +
                "        ntb = this.RemoveRight(p_node,c_node) ;\n" +
                "        else {\n" +
                "        auxkey1 = c_node.GetKey();\n" +
                "        //auxtree01 = p_node.GetLeft() ;\n" +
                "        //auxkey2 = auxtree01.GetKey() ;\n" +
                "        auxkey2 = (p_node.GetLeft()).GetKey() ;\n" +
                "        if (this.Compare(auxkey1,auxkey2)) {\n" +
                "            ntb = p_node.SetLeft(my_null);\n" +
                "            ntb = p_node.SetHas_Left(false);\n" +
                "        }\n" +
                "        else {\n" +
                "            ntb = p_node.SetRight(my_null);\n" +
                "            ntb = p_node.SetHas_Right(false);\n" +
                "        }\n" +
                "        }\n" +
                "    return true ;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    // Copy the child key to the parent until a leaf is\n" +
                "    // found and remove the leaf. This is done with the\n" +
                "    // right subtree\n" +
                "    public boolean RemoveRight(Tree p_node, Tree c_node){\n" +
                "    boolean ntb ;\n" +
                "\n" +
                "    while (c_node.GetHas_Right()){\n" +
                "        //auxtree01 = c_node.GetRight() ;\n" +
                "        //auxint02 = auxtree01.GetKey();\n" +
                "        //ntb = c_node.SetKey(auxint02);\n" +
                "        ntb = c_node.SetKey((c_node.GetRight()).GetKey());\n" +
                "        p_node = c_node ;\n" +
                "        c_node = c_node.GetRight() ;\n" +
                "    }\n" +
                "    ntb = p_node.SetRight(my_null);\n" +
                "    ntb = p_node.SetHas_Right(false);\n" +
                "    return true ;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    // Copy the child key to the parent until a leaf is\n" +
                "    // found and remove the leaf. This is done with the\n" +
                "    // left subtree\n" +
                "    public boolean RemoveLeft(Tree p_node, Tree c_node){\n" +
                "    boolean ntb ;\n" +
                "\n" +
                "    while (c_node.GetHas_Left()){\n" +
                "        //auxtree01 = c_node.GetLeft() ;\n" +
                "        //auxint02 = auxtree01.GetKey();\n" +
                "        //ntb = c_node.SetKey(auxint02);\n" +
                "        ntb = c_node.SetKey((c_node.GetLeft()).GetKey());\n" +
                "        p_node = c_node ;\n" +
                "        c_node = c_node.GetLeft() ;\n" +
                "    }\n" +
                "    ntb = p_node.SetLeft(my_null);\n" +
                "    ntb = p_node.SetHas_Left(false);\n" +
                "    return true ;\n" +
                "    }\n" +
                "\n" +
                "    // Search for an elemnt in the tree\n" +
                "    public int Search(int v_key){\n" +
                "    boolean cont ;\n" +
                "    int ifound ;\n" +
                "    Tree current_node;\n" +
                "    int key_aux ;\n" +
                "\n" +
                "    current_node = this ;\n" +
                "    cont = true ;\n" +
                "    ifound = 0 ;\n" +
                "    while (cont){\n" +
                "        key_aux = current_node.GetKey();\n" +
                "        if (v_key < key_aux)\n" +
                "        if (current_node.GetHas_Left())\n" +
                "            current_node = current_node.GetLeft() ;\n" +
                "        else cont = false ;\n" +
                "        else \n" +
                "        if (key_aux < v_key)\n" +
                "            if (current_node.GetHas_Right())\n" +
                "            current_node = current_node.GetRight() ;\n" +
                "            else cont = false ;\n" +
                "        else { \n" +
                "            ifound = 1 ;\n" +
                "            cont = false ;\n" +
                "        }\n" +
                "    }\n" +
                "    return ifound ;\n" +
                "    }\n" +
                "\n" +
                "    // Invoke the method to really print the tree elements\n" +
                "    public boolean Print(){\n" +
                "    Tree current_node;\n" +
                "    boolean ntb ;\n" +
                "\n" +
                "    current_node = this ;\n" +
                "    ntb = this.RecPrint(current_node);\n" +
                "    return true ;\n" +
                "    }\n" +
                "\n" +
                "    // Print the elements of the tree\n" +
                "    public boolean RecPrint(Tree node){\n" +
                "    boolean ntb ;\n" +
                "\n" +
                "    if (node.GetHas_Left()){\n" +
                "        //auxtree01 = node.GetLeft() ;\n" +
                "        //ntb = this.RecPrint(auxtree01);\n" +
                "        ntb = this.RecPrint(node.GetLeft());\n" +
                "    } else ntb = true ;\n" +
                "    System.out.println(node.GetKey());\n" +
                "    if (node.GetHas_Right()){\n" +
                "        //auxtree01 = node.GetRight() ;\n" +
                "        //ntb = this.RecPrint(auxtree01);\n" +
                "        ntb = this.RecPrint(node.GetRight());\n" +
                "    } else ntb = true ;\n" +
                "    return true ;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "   \n");

        try
        {
            miniJavaLexer lexer  = new miniJavaLexer(stream);
            TokenStream tokenStream = new CommonTokenStream(lexer);
            miniJavaParser parser = new miniJavaParser(tokenStream);
            //parser.removeErrorListeners();
            //parser.addErrorListener(new test_listener.VerboseListener());
            parser.addErrorListener(new test_listener2.UnderlineListener());
            ParseTree tree = parser.goal();

            ParseTreeWalker walker = new ParseTreeWalker();
            PhaseDefine def = new PhaseDefine();
            walker.walk(def, tree);
            // create next phase and feed symbol table info from def to ref phase
            PhaseCheck ref = new PhaseCheck(def.globals, def.scopes);
            walker.walk(ref, tree);

            JFrame frame = new JFrame("Abstract Syntax Tree GUI(By Qingfu Wan)");
            JPanel panel = new JPanel();
            TreeViewer viewr = new TreeViewer(Arrays.asList(
                    parser.getRuleNames()),tree);
            viewr.setScale(1.0);//scale a little
            panel.add(viewr);

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1366,768);
            frame.setVisible(true);

        }
        catch (RecognitionException ex)
        {
            System.out.print("fsd");
        }




    }
}