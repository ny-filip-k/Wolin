import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PolishJava {

    private static final Map<String, String> MAP = Map.ofEntries(
            Map.entry("abstrakcyjny", "abstract"),
            Map.entry("abstrakcyjnego", "abstract"),
            Map.entry("abstrakcyjnemu", "abstract"),
            Map.entry("abstrakcyjnym", "abstract"),
            Map.entry("abstrakcyjna", "abstract"),
            Map.entry("abstrakcyjnej", "abstract"),
            Map.entry("abstrakcyjną", "abstract"),
            Map.entry("abstrakcyjne", "abstract"),
            Map.entry("abstrakcyjni", "abstract"),
            Map.entry("abstrakcyjnych", "abstract"),
            Map.entry("abstrakcyjnymi", "abstract"),

            Map.entry("asercja", "assert"),
            Map.entry("asercji", "assert"),
            Map.entry("asercję", "assert"),
            Map.entry("asercją", "assert"),
            Map.entry("asercjo", "assert"),

            Map.entry("wartość_logiczna", "boolean"),
            Map.entry("wartości_logicznej", "boolean"),
            Map.entry("wartość_logiczną", "boolean"),
            Map.entry("wartością_logiczną", "boolean"),
            Map.entry("wartości_logiczna", "boolean"),

            Map.entry("przerwij", "break"),
            Map.entry("przerwijmy", "break"),
            Map.entry("przerwijcie", "break"),

            Map.entry("bajt", "byte"),
            Map.entry("bajtu", "byte"),
            Map.entry("bajtowi", "byte"),
            Map.entry("bajtem", "byte"),
            Map.entry("bajcie", "byte"),

            Map.entry("złap", "catch"),
            Map.entry("złapmy", "catch"),
            Map.entry("złapcie", "catch"),

            Map.entry("znak", "char"),
            Map.entry("znaku", "char"),
            Map.entry("znakowi", "char"),
            Map.entry("znakiem", "char"),

            Map.entry("klasa", "class"),
            Map.entry("klasy", "class"),
            Map.entry("klasie", "class"),
            Map.entry("klasę", "class"),
            Map.entry("klasą", "class"),
            Map.entry("klaso", "class"),

            Map.entry("stała", "const"),
            Map.entry("stałej", "const"),
            Map.entry("stałą", "const"),
            Map.entry("stało", "const"),

            Map.entry("czyń", "continue"),
            Map.entry("czyńmy", "continue"),
            Map.entry("czyńcie", "continue"),

            Map.entry("domyślny", "default"),
            Map.entry("domyślnego", "default"),
            Map.entry("domyślnemu", "default"),
            Map.entry("domyślnym", "default"),
            Map.entry("domyślna", "default"),
            Map.entry("domyślnej", "default"),
            Map.entry("domyślną", "default"),
            Map.entry("domyślne", "default"),
            Map.entry("domyślni", "default"),
            Map.entry("domyślnych", "default"),
            Map.entry("domyślnymi", "default"),

            Map.entry("rób", "do"),
            Map.entry("róbmy", "do"),
            Map.entry("róbcie", "do"),

            Map.entry("liczba_zmiennoprzecinkowa_podwójnej_precyzji", "double"),
            Map.entry("liczby_zmiennoprzecinkowej_podwójnej_precyzji", "double"),
            Map.entry("liczbie_zmiennoprzecinkowej_podwójnej_precyzji", "double"),
            Map.entry("liczbę_zmiennoprzecinkową_podwójnej_precyzji", "double"),
            Map.entry("liczbą_zmiennoprzecinkową_podwójnej_precyzji", "double"),
            Map.entry("liczbo_zmiennoprzecinkowa_podwójnej_precyzji", "double"),

            Map.entry("w_przeciwnym_razie", "else"),

            Map.entry("typ_wyliczeniowy", "enum"),
            Map.entry("typu_wyliczeniowego", "enum"),
            Map.entry("typowi_wyliczeniowemu", "enum"),
            Map.entry("typem_wyliczeniowym", "enum"),
            Map.entry("typie_wyliczeniowym", "enum"),
            Map.entry("typie_wyliczeniowy", "enum"),

            Map.entry("rozszerzam", "extends"),
            Map.entry("rozszerzasz", "extends"),
            Map.entry("rozszerza", "extends"),
            Map.entry("rozszerzamy", "extends"),
            Map.entry("rozszerzacie", "extends"),
            Map.entry("rozszerzają", "extends"),

            Map.entry("ostateczny", "final"),
            Map.entry("ostatecznego", "final"),
            Map.entry("ostatecznemu", "final"),
            Map.entry("ostatecznym", "final"),
            Map.entry("ostateczna", "final"),
            Map.entry("ostatecznej", "final"),
            Map.entry("ostateczną", "final"),
            Map.entry("ostateczne", "final"),
            Map.entry("ostateczni", "final"),
            Map.entry("ostatecznych", "final"),
            Map.entry("ostatecznymi", "final"),

            Map.entry("ostatecznie", "finally"),

            Map.entry("liczba_zmiennoprzecinkowa", "float"),
            Map.entry("liczby_zmiennoprzecinkowej", "float"),
            Map.entry("liczbie_zmiennoprzecinkowej", "float"),
            Map.entry("liczbę_zmiennoprzecinkową", "float"),
            Map.entry("liczbą_zmiennoprzecinkową", "float"),
            Map.entry("liczbo_zmiennoprzecinkowa", "float"),

            Map.entry("poprzez", "for"),

            Map.entry("idź_do", "goto"),
            Map.entry("idźmy_do", "goto"),
            Map.entry("idźcie_do", "goto"),

            Map.entry("jeśli", "if"),

            Map.entry("implementuję", "implements"),
            Map.entry("implementujesz", "implements"),
            Map.entry("implementuje", "implements"),
            Map.entry("implementujemy", "implements"),
            Map.entry("implementujecie", "implements"),
            Map.entry("implementują", "implements"),

            Map.entry("przywieź", "import"),
            Map.entry("przywieźmy", "import"),
            Map.entry("przywieźcie", "import"),

            Map.entry("jest_wystąpieniem", "instanceof"),
            Map.entry("jestem_wystąpieniem", "instanceof"),
            Map.entry("jesteś_wystąpieniem", "instanceof"),
            Map.entry("jesteśmy_wystąpieniem", "instanceof"),
            Map.entry("jesteście_wystąpieniem", "instanceof"),
            Map.entry("są_wystąpieniem", "instanceof"),

            Map.entry("liczba_całkowita", "int"),
            Map.entry("liczby_całkowitej", "int"),
            Map.entry("liczbie_całkowitej", "int"),
            Map.entry("liczbę_całkowitą", "int"),
            Map.entry("liczbą_całkowitą", "int"),
            Map.entry("liczbo_całkowita", "int"),

            Map.entry("międzymordzie", "interface"),
            Map.entry("międzymordzia", "interface"),
            Map.entry("międzymordziu", "interface"),
            Map.entry("międzymordziem", "interface"),

            Map.entry("liczba_całkowita_długiego_zakresu", "long"),
            Map.entry("liczby_całkowitej_długiego_zakresu", "long"),
            Map.entry("liczbie_całkowitej_długiego_zakresu", "long"),
            Map.entry("liczbę_całkowitą_długiego_zakresu", "long"),
            Map.entry("liczbą_całkowitą_długiego_zakresu", "long"),
            Map.entry("liczbo_całkowita_długiego_zakresu", "long"),

            Map.entry("natywny", "native"),
            Map.entry("natywnego", "native"),
            Map.entry("natywnemu", "native"),
            Map.entry("natywnym", "native"),
            Map.entry("natywna", "native"),
            Map.entry("natywnej", "native"),
            Map.entry("natywną", "native"),
            Map.entry("natywne", "native"),
            Map.entry("natywni", "native"),
            Map.entry("natywnych", "native"),
            Map.entry("natywnymi", "native"),

            Map.entry("nowy", "new"),
            Map.entry("nowego", "new"),
            Map.entry("nowemu", "new"),
            Map.entry("nowym", "new"),
            Map.entry("nowa", "new"),
            Map.entry("nowej", "new"),
            Map.entry("nową", "new"),
            Map.entry("nowe", "new"),
            Map.entry("nowi", "new"),
            Map.entry("nowych", "new"),
            Map.entry("nowymi", "new"),

            Map.entry("pakunek", "package"),
            Map.entry("pakunku", "package"),
            Map.entry("pakunkowi", "package"),
            Map.entry("pakunkiem", "package"),

            Map.entry("prywatny", "private"),
            Map.entry("prywatnego", "private"),
            Map.entry("prywatnemu", "private"),
            Map.entry("prywatnym", "private"),
            Map.entry("prywatna", "private"),
            Map.entry("prywatnej", "private"),
            Map.entry("prywatną", "private"),
            Map.entry("prywatne", "private"),
            Map.entry("prywatni", "private"),
            Map.entry("prywatnych", "private"),
            Map.entry("prywatnymi", "private"),

            Map.entry("chroniony", "protected"),
            Map.entry("chronionego", "protected"),
            Map.entry("chronionemu", "protected"),
            Map.entry("chronionym", "protected"),
            Map.entry("chroniona", "protected"),
            Map.entry("chronionej", "protected"),
            Map.entry("chronioną", "protected"),
            Map.entry("chronione", "protected"),
            Map.entry("chronieni", "protected"),
            Map.entry("chronionych", "protected"),
            Map.entry("chronionymi", "protected"),

            Map.entry("publiczny", "public"),
            Map.entry("publicznego", "public"),
            Map.entry("publicznemu", "public"),
            Map.entry("publicznym", "public"),
            Map.entry("publiczna", "public"),
            Map.entry("publicznej", "public"),
            Map.entry("publiczną", "public"),
            Map.entry("publiczne", "public"),
            Map.entry("publiczni", "public"),
            Map.entry("publicznych", "public"),
            Map.entry("publicznymi", "public"),

            Map.entry("zwróć", "return"),
            Map.entry("zwróćmy", "return"),
            Map.entry("zwróćcie", "return"),

            Map.entry("krótka_liczba_całkowita", "short"),
            Map.entry("krótkiej_liczby_całkowitej", "short"),
            Map.entry("krótkiej_liczbie_całkowitej", "short"),
            Map.entry("krótką_liczbę_całkowitą", "short"),
            Map.entry("krótką_liczbą_całkowitą", "short"),
            Map.entry("krótka_liczbo_całkowita", "short"),

            Map.entry("statyczny", "static"),
            Map.entry("statycznego", "static"),
            Map.entry("statycznemu", "static"),
            Map.entry("statycznym", "static"),
            Map.entry("statyczna", "static"),
            Map.entry("statycznej", "static"),
            Map.entry("statyczną", "static"),
            Map.entry("statyczne", "static"),
            Map.entry("statyczni", "static"),
            Map.entry("statycznych", "static"),
            Map.entry("statycznymi", "static"),

            Map.entry("ściśle_zmiennoprzecinkowy", "strictfp"),
            Map.entry("ściśle_zmiennoprzecinkowego", "strictfp"),
            Map.entry("ściśle_zmiennoprzecinkowemu", "strictfp"),
            Map.entry("ściśle_zmiennoprzecinkowym", "strictfp"),
            Map.entry("ściśle_zmiennoprzecinkowa", "strictfp"),
            Map.entry("ściśle_zmiennoprzecinkowej", "strictfp"),
            Map.entry("ściśle_zmiennoprzecinkową", "strictfp"),
            Map.entry("ściśle_zmiennoprzecinkowe", "strictfp"),
            Map.entry("ściśle_zmiennoprzecinkowi", "strictfp"),
            Map.entry("ściśle_zmiennoprzecinkowych", "strictfp"),
            Map.entry("ściśle_zmiennoprzecinkowymi", "strictfp"),

            Map.entry("baza", "super"),
            Map.entry("bazy", "super"),
            Map.entry("bazie", "super"),
            Map.entry("bazę", "super"),
            Map.entry("bazą", "super"),
            Map.entry("bazo", "super"),

            Map.entry("przełącz", "switch"),
            Map.entry("przełączmy", "switch"),
            Map.entry("przełączcie", "switch"),

            Map.entry("zsynchronizowany", "synchronized"),
            Map.entry("zsynchronizowanego", "synchronized"),
            Map.entry("zsynchronizowanemu", "synchronized"),
            Map.entry("zsynchronizowanym", "synchronized"),
            Map.entry("zsynchronizowana", "synchronized"),
            Map.entry("zsynchronizowanej", "synchronized"),
            Map.entry("zsynchronizowaną", "synchronized"),
            Map.entry("zsynchronizowane", "synchronized"),
            Map.entry("zsynchronizowani", "synchronized"),
            Map.entry("zsynchronizowanych", "synchronized"),
            Map.entry("zsynchronizowanymi", "synchronized"),

            Map.entry("ten", "this"),
            Map.entry("tego", "this"),
            Map.entry("temu", "this"),
            Map.entry("tym", "this"),
            Map.entry("ta", "this"),
            Map.entry("tej", "this"),
            Map.entry("tę", "this"),
            Map.entry("tą", "this"),
            Map.entry("to", "this"),
            Map.entry("ci", "this"),
            Map.entry("tych", "this"),
            Map.entry("tymi", "this"),

            Map.entry("rzuć", "throw"),
            Map.entry("rzućmy", "throw"),
            Map.entry("rzućcie", "throw"),

            Map.entry("rzucam", "throws"),
            Map.entry("rzucasz", "throws"),
            Map.entry("rzuca", "throws"),
            Map.entry("rzucamy", "throws"),
            Map.entry("rzucacie", "throws"),
            Map.entry("rzucają", "throws"),

            Map.entry("przemijający", "transient"),
            Map.entry("przemijającego", "transient"),
            Map.entry("przemijającemu", "transient"),
            Map.entry("przemijającym", "transient"),
            Map.entry("przemijająca", "transient"),
            Map.entry("przemijającej", "transient"),
            Map.entry("przemijającą", "transient"),
            Map.entry("przemijające", "transient"),
            Map.entry("przemijających", "transient"),
            Map.entry("przemijającymi", "transient"),

            Map.entry("spróbuj", "try"),
            Map.entry("spróbujmy", "try"),
            Map.entry("spróbujcie", "try"),

            Map.entry("pustka", "void"),
            Map.entry("pustki", "void"),
            Map.entry("pustce", "void"),
            Map.entry("pustkę", "void"),
            Map.entry("pustką", "void"),
            Map.entry("pustko", "void"),

            Map.entry("podczas_gdy", "while"),

            Map.entry("wypluj", "System.out.println")
    );

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: input.pjava output.java");
            return;
        }

        String input = Files.readString(Path.of(args[0]));
        String output = process(input);
        Files.writeString(Path.of(args[1]), output);
    }

    private static String process(String code) {
        StringBuilder out = new StringBuilder();

        boolean inString = false;
        boolean inChar = false;
        boolean inLineComment = false;
        boolean inBlockComment = false;

        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            char next = (i + 1 < code.length()) ? code.charAt(i + 1) : '\0';

            // --- handle comments ---
            if (!inString && !inChar) {
                if (!inBlockComment && c == '/' && next == '/') {
                    inLineComment = true;
                } else if (!inLineComment && c == '/' && next == '*') {
                    inBlockComment = true;
                }
            }

            if (inLineComment && c == '\n') inLineComment = false;
            if (inBlockComment && c == '*' && next == '/') {
                inBlockComment = false;
                out.append(c).append(next);
                i++;
                continue;
            }

            // --- handle strings ---
            if (!inLineComment && !inBlockComment) {
                if (c == '"' && !inChar) inString = !inString;
                if (c == '\'' && !inString) inChar = !inChar;
            }

            // --- token logic ---
            if (!inString && !inChar && !inLineComment && !inBlockComment) {
                if (Character.isJavaIdentifierPart(c)) {
                    currentToken.append(c);
                    continue;
                } else {
                    flushToken(out, currentToken);
                }
            }

            out.append(c);
        }

        flushToken(out, currentToken);
        return out.toString();
    }

    private static void flushToken(StringBuilder out, StringBuilder token) {
        if (token.length() > 0) {
            String word = token.toString();
            out.append(MAP.getOrDefault(word, word));
            token.setLength(0);
        }
    }
}