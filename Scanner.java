import java.util.ArrayList;
import java.util.List;

public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    public Scanner(String source) {
        this.source = source;
    }

    List<Token> scanTokens() {
        while (!isAtEnd()) {
            // Scan next token
            // This is a placeholder for actual scanning logic
            tokens.add(new Token(TokenType.EOF, "", null, 1));
        }
        
        tokens.add(new Token(TokenType.EOF, "", null, 1));
        return tokens;
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }
}
