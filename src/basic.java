import org.antlr.v4.runtime.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class basic
{
    public static void underlineError(Recognizer recognizer,
                                      Token offendingToken, int line,
                                      int charPositionInLine)
    {
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

    public static void readToBuffer(StringBuffer buffer, String FilePath)
    {
        try
        {
            InputStream input_stream = new FileInputStream(FilePath);
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(input_stream));
            line = reader.readLine();
            while (line != null)
            {
                buffer.append(line);
                buffer.append("\n");
                line = reader.readLine();
            }
            reader.close();
            input_stream.close();
        }
        catch (IOException ex)
        {
            return;
        }
    }

    public static String readFile(String FilePath)
    {
        StringBuffer string_buffer = new StringBuffer();
        readToBuffer(string_buffer, FilePath);
        return string_buffer.toString();
    }

    public static String test_string = "";

    public static void ReadTestString()
    {
        String file_path = readFile("input/file_path.in");
        file_path = file_path.substring(0, file_path.length() - 1);
        test_string = readFile(file_path);
    }

    public static boolean bail()
    {
        String bail_flag = readFile("input/bail_or_not.in");
        bail_flag = bail_flag.substring(0, bail_flag.length() - 1);
        if (bail_flag.equals("true")) return true; else return false;
    }
}