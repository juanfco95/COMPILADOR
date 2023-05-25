// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: C:/Users/alexm/Downloads/Compilador-main (12)/Compilador-main/src/compilador/lexic/lexic.flex

package compilador.lexic;

import java.io.*;
import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import compilador.sintactic.ParserSym;
import java_cup.runtime.ComplexSymbolFactory.Location;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\2\0\1\2\22\0\1\1\1\3"+
    "\3\0\1\4\2\0\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\0\1\13\12\14\1\0\1\15\1\16\1\17"+
    "\1\20\2\0\17\21\1\22\3\21\1\23\6\21\4\0"+
    "\1\21\1\0\1\24\1\25\1\26\1\27\1\30\1\31"+
    "\1\32\1\21\1\33\2\21\1\34\1\35\1\36\1\37"+
    "\1\40\1\21\1\41\1\42\1\43\1\44\1\45\4\21"+
    "\1\46\1\0\1\47\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\16\21\1\22\1\23\2\0\13\21\1\24\2\21"+
    "\1\25\2\21\1\26\1\27\1\30\10\21\1\31\1\32"+
    "\6\21\1\33\2\21\1\34\4\21\1\35\1\21\1\36"+
    "\2\21\1\37\5\21\1\40\10\21\1\41\1\21\1\42"+
    "\1\21\1\43\4\21\1\44\5\21\1\45\3\21\1\46";

  private static int [] zzUnpackAction() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\50\0\120\0\170\0\50\0\50\0\50\0\50"+
    "\0\50\0\50\0\50\0\50\0\240\0\50\0\310\0\50"+
    "\0\360\0\u0118\0\u0140\0\u0168\0\u0190\0\u01b8\0\u01e0\0\u0208"+
    "\0\u0230\0\u0258\0\u0280\0\u02a8\0\u02d0\0\u02f8\0\u0320\0\50"+
    "\0\50\0\u0348\0\u0370\0\u0398\0\u03c0\0\u03e8\0\u0410\0\u0438"+
    "\0\u0460\0\u0488\0\u04b0\0\u04d8\0\u0500\0\u0528\0\u0118\0\u0550"+
    "\0\u0578\0\u05a0\0\u05c8\0\u05f0\0\50\0\50\0\u0118\0\u0618"+
    "\0\u0640\0\u0668\0\u0690\0\u06b8\0\u06e0\0\u0708\0\u0730\0\50"+
    "\0\u0118\0\u0758\0\u0780\0\u07a8\0\u07d0\0\u07f8\0\u0820\0\u0118"+
    "\0\u0848\0\u0870\0\u0118\0\u0898\0\u08c0\0\u08e8\0\u0910\0\u0118"+
    "\0\u0938\0\u0118\0\u0960\0\u0988\0\u0118\0\u09b0\0\u09d8\0\u0a00"+
    "\0\u0a28\0\u0a50\0\u0118\0\u0a78\0\u0aa0\0\u0ac8\0\u0af0\0\u0b18"+
    "\0\u0b40\0\u0b68\0\u0b90\0\u0118\0\u0bb8\0\u0118\0\u0be0\0\u0118"+
    "\0\u0c08\0\u0c30\0\u0c58\0\u0c80\0\u0118\0\u0ca8\0\u0cd0\0\u0cf8"+
    "\0\u0d20\0\u0d48\0\u0118\0\u0d70\0\u0d98\0\u0dc0\0\u0118";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\3\22\1\23\1\24\1\25\1\22\1\26\1\27"+
    "\2\22\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\2\22\1\37\1\40\1\41\51\0\1\3\50\0\1\4"+
    "\61\0\1\15\72\0\1\42\47\0\1\43\24\0\1\22"+
    "\4\0\25\22\16\0\1\22\4\0\15\22\1\44\7\22"+
    "\16\0\1\22\4\0\16\22\1\45\6\22\16\0\1\22"+
    "\4\0\7\22\1\46\6\22\1\47\6\22\16\0\1\22"+
    "\4\0\15\22\1\50\7\22\16\0\1\22\4\0\3\22"+
    "\1\51\17\22\1\52\1\22\16\0\1\22\4\0\13\22"+
    "\1\53\11\22\16\0\1\22\4\0\7\22\1\54\15\22"+
    "\16\0\1\22\4\0\16\22\1\55\4\22\1\56\1\22"+
    "\16\0\1\22\4\0\20\22\1\57\4\22\16\0\1\22"+
    "\4\0\20\22\1\60\4\22\16\0\1\22\4\0\7\22"+
    "\1\61\15\22\16\0\1\22\4\0\12\22\1\62\3\22"+
    "\1\63\6\22\16\0\1\22\4\0\16\22\1\64\6\22"+
    "\21\0\1\65\47\0\1\66\44\0\1\22\4\0\6\22"+
    "\1\67\16\22\16\0\1\22\4\0\16\22\1\70\6\22"+
    "\16\0\1\22\4\0\20\22\1\71\4\22\16\0\1\22"+
    "\4\0\15\22\1\72\7\22\16\0\1\22\4\0\22\22"+
    "\1\73\2\22\16\0\1\22\4\0\13\22\1\74\11\22"+
    "\16\0\1\22\4\0\15\22\1\75\7\22\16\0\1\22"+
    "\4\0\7\22\1\76\15\22\16\0\1\22\4\0\15\22"+
    "\1\77\7\22\5\0\1\100\10\0\1\22\4\0\25\22"+
    "\16\0\1\22\4\0\13\22\1\101\11\22\16\0\1\22"+
    "\4\0\12\22\1\102\12\22\16\0\1\22\4\0\22\22"+
    "\1\103\2\22\16\0\1\22\4\0\15\22\1\104\7\22"+
    "\16\0\1\22\4\0\20\22\1\105\4\22\16\0\1\22"+
    "\4\0\12\22\1\106\12\22\16\0\1\22\4\0\13\22"+
    "\1\107\11\22\16\0\1\22\4\0\22\22\1\110\2\22"+
    "\16\0\1\22\4\0\21\22\1\111\3\22\16\0\1\22"+
    "\4\0\7\22\1\112\15\22\16\0\1\22\4\0\21\22"+
    "\1\110\3\22\16\0\1\22\4\0\5\22\1\113\17\22"+
    "\16\0\1\22\4\0\11\22\1\114\13\22\16\0\1\22"+
    "\4\0\22\22\1\115\2\22\16\0\1\22\4\0\15\22"+
    "\1\116\7\22\16\0\1\22\4\0\16\22\1\117\6\22"+
    "\16\0\1\22\4\0\16\22\1\120\6\22\16\0\1\22"+
    "\4\0\22\22\1\121\2\22\16\0\1\22\4\0\6\22"+
    "\1\122\16\22\16\0\1\22\4\0\7\22\1\123\15\22"+
    "\16\0\1\22\4\0\22\22\1\124\2\22\16\0\1\22"+
    "\4\0\20\22\1\125\4\22\16\0\1\22\4\0\12\22"+
    "\1\126\12\22\16\0\1\22\4\0\20\22\1\127\4\22"+
    "\16\0\1\22\4\0\5\22\1\130\17\22\16\0\1\22"+
    "\4\0\20\22\1\131\4\22\16\0\1\22\4\0\12\22"+
    "\1\132\12\22\16\0\1\22\4\0\3\22\1\133\21\22"+
    "\16\0\1\22\4\0\3\22\1\134\21\22\16\0\1\22"+
    "\4\0\20\22\1\135\4\22\16\0\1\22\4\0\7\22"+
    "\1\136\15\22\16\0\1\22\4\0\12\22\1\137\12\22"+
    "\16\0\1\22\4\0\15\22\1\140\7\22\16\0\1\22"+
    "\4\0\6\22\1\141\16\22\16\0\1\22\4\0\15\22"+
    "\1\142\7\22\16\0\1\22\4\0\2\22\1\143\22\22"+
    "\16\0\1\22\4\0\21\22\1\144\3\22\16\0\1\22"+
    "\4\0\17\22\1\145\5\22\16\0\1\22\4\0\3\22"+
    "\1\146\21\22\16\0\1\22\4\0\3\22\1\147\21\22"+
    "\16\0\1\22\4\0\22\22\1\150\2\22\16\0\1\22"+
    "\4\0\7\22\1\151\15\22\16\0\1\22\4\0\3\22"+
    "\1\152\21\22\16\0\1\22\4\0\1\22\1\153\23\22"+
    "\16\0\1\22\4\0\5\22\1\154\17\22\16\0\1\22"+
    "\4\0\13\22\1\155\11\22\16\0\1\22\4\0\3\22"+
    "\1\156\21\22\16\0\1\22\4\0\13\22\1\157\11\22"+
    "\16\0\1\22\4\0\15\22\1\160\7\22\16\0\1\22"+
    "\4\0\3\22\1\161\21\22\16\0\1\22\4\0\22\22"+
    "\1\162\2\22\16\0\1\22\4\0\22\22\1\163\2\22"+
    "\16\0\1\22\4\0\3\22\1\164\21\22\16\0\1\22"+
    "\4\0\13\22\1\165\11\22\16\0\1\22\4\0\13\22"+
    "\1\166\11\22\16\0\1\22\4\0\3\22\1\167\21\22"+
    "\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3560];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\10\11\1\1\1\11\1\1\1\11"+
    "\17\1\2\11\2\0\21\1\2\11\11\1\1\11\67\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    public int line = yyline;
    public int column = yycolumn;
    private ComplexSymbol symbol(int type) {
        Location left = new Location(yyline + 1,
                yycolumn + 1, (int) yychar);
        Location right = new Location(yyline + 1,
                yycolumn + yylength(), (int) (yychar + yylength()));
        return new ComplexSymbol(ParserSym.terminalNames[type], type, left, right);
    }
    private ComplexSymbol symbol(int type, Object value) {
        Location left = new Location(yyline + 1,
                yycolumn + 1, (int) yychar);
        Location right = new Location(yyline + 1,
                yycolumn + yylength(), (int) (yychar + yylength()));
        return new ComplexSymbol(ParserSym.terminalNames[type], type, left, right, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {   return symbol(ParserSym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return symbol(ParserSym.error);
            }
            // fall through
          case 39: break;
          case 2:
            { /* no fer tres */
            }
            // fall through
          case 40: break;
          case 3:
            { return symbol(ParserSym.NEWLINE);
            }
            // fall through
          case 41: break;
          case 4:
            { return symbol(ParserSym.MOD);
            }
            // fall through
          case 42: break;
          case 5:
            { return symbol(ParserSym.LPAREN);
            }
            // fall through
          case 43: break;
          case 6:
            { return symbol(ParserSym.RPAREN);
            }
            // fall through
          case 44: break;
          case 7:
            { return symbol(ParserSym.MUL);
            }
            // fall through
          case 45: break;
          case 8:
            { return symbol(ParserSym.ADD);
            }
            // fall through
          case 46: break;
          case 9:
            { return symbol(ParserSym.COMA);
            }
            // fall through
          case 47: break;
          case 10:
            { return symbol(ParserSym.SUB);
            }
            // fall through
          case 48: break;
          case 11:
            { return symbol(ParserSym.DIV);
            }
            // fall through
          case 49: break;
          case 12:
            { return symbol(ParserSym.numero, this.yytext());
            }
            // fall through
          case 50: break;
          case 13:
            { return symbol(ParserSym.PNTCM);
            }
            // fall through
          case 51: break;
          case 14:
            { return symbol(ParserSym.MENOR);
            }
            // fall through
          case 52: break;
          case 15:
            { return symbol(ParserSym.IGUAL);
            }
            // fall through
          case 53: break;
          case 16:
            { return symbol(ParserSym.MAYOR);
            }
            // fall through
          case 54: break;
          case 17:
            { return symbol(ParserSym.ID, this.yytext());
            }
            // fall through
          case 55: break;
          case 18:
            { return symbol(ParserSym.LCLAVE);
            }
            // fall through
          case 56: break;
          case 19:
            { return symbol(ParserSym.RCLAVE);
            }
            // fall through
          case 57: break;
          case 20:
            { return symbol(ParserSym.OR);
            }
            // fall through
          case 58: break;
          case 21:
            { return symbol(ParserSym.COND);
            }
            // fall through
          case 59: break;
          case 22:
            { return symbol(ParserSym.MENIG);
            }
            // fall through
          case 60: break;
          case 23:
            { return symbol(ParserSym.MAYIG);
            }
            // fall through
          case 61: break;
          case 24:
            { return symbol(ParserSym.AND);
            }
            // fall through
          case 62: break;
          case 25:
            { return symbol(ParserSym.NO);
            }
            // fall through
          case 63: break;
          case 26:
            { return symbol(ParserSym.NULL);
            }
            // fall through
          case 64: break;
          case 27:
            { return symbol(ParserSym.VBOOL,this.yytext());
            }
            // fall through
          case 65: break;
          case 28:
            { return symbol(ParserSym.FUNC);
            }
            // fall through
          case 66: break;
          case 29:
            { return symbol(ParserSym.ECOND);
            }
            // fall through
          case 67: break;
          case 30:
            { return symbol(ParserSym.VOID);
            }
            // fall through
          case 68: break;
          case 31:
            { return symbol(ParserSym.ENTER);
            }
            // fall through
          case 69: break;
          case 32:
            { return symbol(ParserSym.BOOL);
            }
            // fall through
          case 70: break;
          case 33:
            { return symbol(ParserSym.MENTRES);
            }
            // fall through
          case 71: break;
          case 34:
            { return symbol(ParserSym.RETORNA);
            }
            // fall through
          case 72: break;
          case 35:
            { return symbol(ParserSym.CONST);
            }
            // fall through
          case 73: break;
          case 36:
            { return symbol(ParserSym.MAIN);
            }
            // fall through
          case 74: break;
          case 37:
            { return symbol(ParserSym.LECT);
            }
            // fall through
          case 75: break;
          case 38:
            { return symbol(ParserSym.SORT);
            }
            // fall through
          case 76: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
