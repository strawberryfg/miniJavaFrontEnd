import org.antlr.runtime.MismatchedNotSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.v4.runtime.*;
import java.util.*;

public class basic {
    public static void underlineError(Recognizer recognizer,
                                      Token offendingToken, int line,
                                      int charPositionInLine) {
        CommonTokenStream tokens =
                (CommonTokenStream) recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();
        PrintContext(input, line, start, stop);
    }

    public static void PrintError(Token t_token, String message)
    {
        System.err.println("Semantic Error:");
        System.err.printf("line %d:%d %s", t_token.getLine(), t_token.getCharPositionInLine(),  message);
        System.err.println();
    }

    public static void PrintContext(String s, int line, int start, int stop)
    {
        String[] lines = s.split("\n");
        String errorLine = lines[line - 1];
        System.err.println(errorLine);
        for (int i = 0; i < start; i++) System.err.print(" ");
        if (start >= 0 && stop >= 0)
        {
            for (int i = start; i <= stop; i++) System.err.print("^");
        }
        System.err.println();
    }

    public static String test_string = "class BinaryTree{\n" +
            "    public static void main(String[] a){\n" +
            "    System.out.println(new BT().Start());\n" +
            "\t\n" +
            "    }\n" +
            "    int f;\t\n" +
            "\tf = 3;\n" +
            "}\n" +
            "class Tree{\n" +
            "    Tree left ;\n" +
            "    Tree right;\n" +
            "\tTree tmp;\n" +
            "    int key ;\n" +
            "\tint Tree;\n" +
            "\tint return;\n" +
            "\tString String;\n" +
            "\tboolean public;\n" +
            "\tTree extends;\n" +
            "\tTree static\n" +
            "\tint f;\n" +
            "\tint zxl;\n" +
            "\tboolean b;\n" +
            "\t\n" +
            "    boolean has_left ;\n" +
            "    boolean has_right ;\n" +
            "\t\n" +
            "    Tree my_null ;\n" +
            "\n" +
            "    // Initialize a node with a key value and no children\n" +
            "    public boolean Init(int v_key){\n" +
            "    key = v_key ;\n" +
            "\tkey = \"fs\";\n" +
            "\tf = new int [3 + b];\t\n" +
            "\tb = 3;\n" +
            "    has_left = false ;\n" +
            "    has_right = false ;\n" +
            "\ttmp = new F();\n" +
            "    return true ;\n" +
            "    }\n" +
            "\n" +
            "    // Update the right child with rn\n" +
            "    public boolean SetRight(Tree rn){\n" +
            "\tif (!f)\n" +
            "\t{\n" +
            "\t    b = true;\n" +
            "\t}\n" +
            "\telse \n" +
            "\t{   \n" +
            "\t   if ((!f))\n" +
            "\t   {\n" +
            "\t       has_right = false;\n" +
            "\t   }\n" +
            "\t   else\n" +
            "\t   {\n" +
            "\t       right = rn ;      \n" +
            "\t   }\t   \n" +
            "\t}\n" +
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
            "\tif (zxl) \n" +
            "\t{\t    \n" +
            "\t    key = 5;\n" +
            "\t}\n" +
            "\telse\n" +
            "\t{\n" +
            "\t\tf = 4;\n" +
            "\t}\n" +
            "    return 3;\n" +
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
            "\tntb = new_node.Init(v_key, 3);\n" +
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
            "\n" +
            "\t// Copy the child key to the parent until a leaf is\n" +
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
            "\t\n" +
            "\n" +
            "    // Check if the element to be removed will use the\n" +
            "    // righ or left subtree if one exists\n" +
            "    public boolean Remove(Tree p_node, Tree c_node){\n" +
            "    boolean ntb ;\n" +
            "\tboolean t_remove;\n" +
            "    int auxkey1 ;\n" +
            "    int auxkey2 ;\n" +
            "    T ff;\n" +
            "\tTree t_tree;\n" +
            "    if (c_node.GetHas_Left()) \n" +
            "        ntb = this.RemoveLeft(p_node,c_node) ;\n" +
            "    else \n" +
            "        if (c_node.GetHas_Right())\n" +
            "        ntb = this.RemoveRight(p_node,c_node) ;\t\t\n" +
            "        else {\n" +
            "\t\tntb = ff.Remove(p_node);\n" +
            "\t\tt_remove = t_tree.Remove_rewrite(p_node);\n" +
            "\t\tt_remove = t_tree.Remove(p_node);\n" +
            "        auxkey1 = c_node.GetKey();\n" +
            "        //auxtree01 = p_node.GetLeft() ;\n" +
            "        //auxkey2 = auxtree01.GetKey() ;\n" +
            "        auxkey2 = (p_node.GetLeft()).GetKey() ;\n" +
            "\t\t\n" +
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
            "\t    // Delete an element from the tree\n" +
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
            "\t\t\t{\n" +
            "\t\t\t\tntb = this.Remove(parent_node,current_node); \n" +
            "\t\t\t\tntb = this.Remove(parent_node);\n" +
            "\t\t\t\tntb = this.Remove(parent_node, current_node, parent_node, 3);\n" +
            "\t\t\t}                \n" +
            "            else ntb = this.Remove(parent_node,current_node);\n" +
            "            found = true ;\n" +
            "            cont = false ;\n" +
            "        }\n" +
            "        is_root = false ;\n" +
            "    }\n" +
            "    return found ;\n" +
            "    }\n" +
            "\n" +
            "    \n" +
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
            "\tSystem.out.println(0ttt);\n" +
            "    if (node.GetHas_Right()){\n" +
            "        //auxtree01 = node.GetRight() ;\n" +
            "        //ntb = this.RecPrint(auxtree01);\n" +
            "        ntb = this.RecPrint(node.GetRight());\n" +
            "    } else ntb = true ;\n" +
            "    return true ;\n" +
            "    }\n" +
            "\n" +
            "}\n" +
            "   \n" +
            "\n" +
            "\n" +
            "// This class invokes the methods to create a tree,\n" +
            "// insert, delete and serach for  elements on it\n" +
            "class BT {\n" +
            "\n" +
            "    public int Start(){\n" +
            "    SegmentTree hello;\n" +
            "    Tree root ;\n" +
            "    boolean ntb ;\n" +
            "    int nti ;\n" +
            "\tint a;\n" +
            "\tint b;\n" +
            "\tint c;\n" +
            "\tint d;\n" +
            "\tint e;\n" +
            "    int [] wqf;\n" +
            "\tint 是3;\n" +
            "\t\n" +
            "    root = new Tree();\n" +
            "    ntb = root.Init(16);\n" +
            "    ntb = root.Print();\n" +
            "    System.out.println(100000000 + \"s\");\n" +
            "    ntb = root.Insert(8) ;\n" +
            "    ntb = root.Print();\n" +
            "    ntb = root.Insert(24 + ( 3 * 5)) ;\n" +
            "    ntb = root.Insert(4 + 3 * 5) ;\n" +
            "    ntb = root.Insert(12) ;\n" +
            "    ntb = root.Insert(20) ;\n" +
            "    ntb = root.Insert(28) ;\n" +
            "    ntb = root.Insert(14) ;\n" +
            "    ntb = root.Print();\n" +
            "\twqf = new int [( (a + b * 5) / 3)];\n" +
            "\twqf[ntb] = \"s\";\n" +
            "\twqf[((3+b)] = 1;\n" +
            "\twqf[((((b+c * d / e)] = 2;\n" +
            "\twqf[23 + (324 * d )))] = 43214;\n" +
            "\twqf[3] = \"fds\";\n" +
            "\twqf[2] = c;\n" +
            "\t\n" +
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
            "class f extends B\n" +
            "{\n" +
            "}\n" +
            "\n";
}