// $ANTLR !Unknown version! grammar/AsmY86.g 2011-08-25 13:22:55

package grammar;

import isa.Memory;
import isa.MemoryCell;
import isa.Instruction;
import isa.Datum;
import arch.y86.isa.Assembler;
import arch.y86.machine.AbstractY86CPU;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class AsmY86Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NewLine", "Comment", "Identifier", "Hex", "Decimal", "Character", "Digit", "HexDigit", "WS", "':'", "'halt'", "'nop'", "'rrmovl'", "'cmovle'", "'cmovl'", "'cmove'", "'cmovne'", "'cmovge'", "'cmovg'", "'irmovl'", "'rmmovl'", "'mrmovl'", "'addl'", "'subl'", "'andl'", "'xorl'", "'mull'", "'divl'", "'modl'", "'iaddl'", "'isubl'", "'iandl'", "'ixorl'", "'imull'", "'idivl'", "'imodl'", "'jmp'", "'jle'", "'jl'", "'je'", "'jne'", "'jge'", "'jg'", "'call'", "'pushl'", "'popl'", "'leave'", "','", "'*'", "'ret'", "'$'", "'('", "')'", "'%eax'", "'%ecx'", "'%edx'", "'%ebx'", "'%esp'", "'%ebp'", "'%esi'", "'%edi'", "'-'", "'.pos'", "'.long'", "'.word'", "'.byte'", "'.align'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int Decimal=8;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int HexDigit=11;
    public static final int Identifier=6;
    public static final int T__55=55;
    public static final int NewLine=4;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int Comment=5;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int Digit=10;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int WS=12;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int Character=9;
    public static final int Hex=7;

    // delegates
    // delegators


        public AsmY86Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public AsmY86Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return AsmY86Parser.tokenNames; }
    public String getGrammarFileName() { return "grammar/AsmY86.g"; }


    public enum LineType {INSTRUCTION, DATA, NULL};
    Memory memory;
    LineType lineType;
    int pc;
    int opCode;
    int[] op = new int[4];
    int opLength;
    String label;
    String comment;
    int dataSize;
    int dataValue;
    int dataCount;
    int pass;

    void init (Memory aMemory, int startingAddress) {
      memory      = aMemory;
      pc          = startingAddress;
      lineType    = LineType.NULL;
      comment     = "";
      label       = "";
    }

    public void checkSyntax (Memory aMemory, int startingAddress) throws Assembler.AssemblyException {
      init (aMemory, startingAddress);
      pass = 0;
      try {
        program ();
      } catch (RecognitionException e) {
        throw new Assembler.AssemblyException ("");
      }
    }

    public void passOne (Memory aMemory, int startingAddress) throws Assembler.AssemblyException {
      init (aMemory, startingAddress);
      pass = 1;
      try {
        program ();
      } catch (RecognitionException e) {
        throw new Assembler.AssemblyException ("");
      }
    }

    public void passTwo (Memory aMemory, int startingAddress) throws Assembler.AssemblyException {
      init (aMemory, startingAddress);
      pass = 2;
      try {
        program ();
      } catch (RecognitionException e) {
        throw new Assembler.AssemblyException ("");
      }
    }

    @Override
    public void emitErrorMessage(String msg) {
      throw new Assembler.AssemblyException (msg);
    }

    int getLabelValue (String label) {
      Integer value = memory.getLabelMap ().getAddress (label);
      if (value==null) {
        if (pass==1)
          value = pc;
        else
          emitErrorMessage (String.format ("Label not found: %s at address %d", label, pc));
      }
      return value.intValue ();
    }

    void writeLine () throws RecognitionException {
      MemoryCell cell = null;
      switch (lineType) {
        case INSTRUCTION:
          try {
            cell = Instruction.valueOf (memory, pc, opCode, op, label, comment);
            if (cell==null)
              throw new RecognitionException ();
            if (pass==1 && !label.trim ().equals ("")) 
              memory.addLabelOnly (cell);
            else if (pass==2)
              memory.add (cell);
            label = "";
            comment = "";
            pc += cell.length ();
          } catch (IndexOutOfBoundsException e) {
            throw new RecognitionException ();
          }
          break;
        case DATA:
          for (int i=0; i<dataCount; i++) {
            cell = Datum.valueOf (memory, pc, dataValue, dataSize, label, comment);
            if (cell==null)
              throw new RecognitionException ();
            if (pass==1 && !label.trim ().equals (""))
              memory.addLabelOnly (cell);
            else if (pass==2)
              memory.add (cell);
            label = "";
            comment = "";
            pc += dataSize;
          }
          label = "";
          comment = "";
          break;
        default:
      }
      lineType = LineType.NULL;
      op[0]=0;
      op[1]=0;
      op[2]=0;
      op[3]=0;
    }



    // $ANTLR start "program"
    // grammar/AsmY86.g:144:1: program : ( line )* EOF ;
    public final void program() throws RecognitionException {
        try {
            // grammar/AsmY86.g:144:9: ( ( line )* EOF )
            // grammar/AsmY86.g:144:11: ( line )* EOF
            {
            // grammar/AsmY86.g:144:11: ( line )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=NewLine && LA1_0<=Identifier)||(LA1_0>=14 && LA1_0<=50)||LA1_0==53||(LA1_0>=66 && LA1_0<=70)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // grammar/AsmY86.g:144:11: line
            	    {
            	    pushFollow(FOLLOW_line_in_program46);
            	    line();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_program49); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "program"


    // $ANTLR start "line"
    // grammar/AsmY86.g:146:1: line : ( labelDeclaration )? ( instruction | directive )? ( NewLine | ( Comment ) ) ;
    public final void line() throws RecognitionException {
        Token Comment1=null;

        try {
            // grammar/AsmY86.g:146:6: ( ( labelDeclaration )? ( instruction | directive )? ( NewLine | ( Comment ) ) )
            // grammar/AsmY86.g:146:8: ( labelDeclaration )? ( instruction | directive )? ( NewLine | ( Comment ) )
            {
            // grammar/AsmY86.g:146:8: ( labelDeclaration )?
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // grammar/AsmY86.g:146:9: labelDeclaration
                    {
                    pushFollow(FOLLOW_labelDeclaration_in_line58);
                    labelDeclaration();

                    state._fsp--;


                    }
                    break;

            }

            // grammar/AsmY86.g:146:28: ( instruction | directive )?
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=14 && LA3_0<=50)||LA3_0==53) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=66 && LA3_0<=70)) ) {
                alt3=2;
            }
            switch (alt3) {
                case 1 :
                    // grammar/AsmY86.g:146:30: instruction
                    {
                    pushFollow(FOLLOW_instruction_in_line64);
                    instruction();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:146:44: directive
                    {
                    pushFollow(FOLLOW_directive_in_line68);
                    directive();

                    state._fsp--;


                    }
                    break;

            }

            // grammar/AsmY86.g:146:57: ( NewLine | ( Comment ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NewLine) ) {
                alt4=1;
            }
            else if ( (LA4_0==Comment) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // grammar/AsmY86.g:146:59: NewLine
                    {
                    match(input,NewLine,FOLLOW_NewLine_in_line75); 

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:146:69: ( Comment )
                    {
                    // grammar/AsmY86.g:146:69: ( Comment )
                    // grammar/AsmY86.g:146:70: Comment
                    {
                    Comment1=(Token)match(input,Comment,FOLLOW_Comment_in_line80); 
                     comment = (Comment1!=null?Comment1.getText():null).substring(1).trim(); 

                    }


                    }
                    break;

            }

            writeLine ();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "line"

    public static class labelDeclaration_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "labelDeclaration"
    // grammar/AsmY86.g:149:1: labelDeclaration : ( Identifier | operand ) ':' ;
    public final AsmY86Parser.labelDeclaration_return labelDeclaration() throws RecognitionException {
        AsmY86Parser.labelDeclaration_return retval = new AsmY86Parser.labelDeclaration_return();
        retval.start = input.LT(1);

        try {
            // grammar/AsmY86.g:150:2: ( ( Identifier | operand ) ':' )
            // grammar/AsmY86.g:150:4: ( Identifier | operand ) ':'
            {
            // grammar/AsmY86.g:150:4: ( Identifier | operand )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Identifier) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=14 && LA5_0<=50)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // grammar/AsmY86.g:150:5: Identifier
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_labelDeclaration100); 

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:150:18: operand
                    {
                    pushFollow(FOLLOW_operand_in_labelDeclaration104);
                    operand();

                    state._fsp--;


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_labelDeclaration107); 
            label = input.toString(retval.start,input.LT(-1)).substring (0, input.toString(retval.start,input.LT(-1)).length ()-1);

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "labelDeclaration"

    public static class label_return extends ParserRuleReturnScope {
        public int value;
    };

    // $ANTLR start "label"
    // grammar/AsmY86.g:151:1: label returns [int value] : ( Identifier | operand ) ;
    public final AsmY86Parser.label_return label() throws RecognitionException {
        AsmY86Parser.label_return retval = new AsmY86Parser.label_return();
        retval.start = input.LT(1);

        try {
            // grammar/AsmY86.g:152:2: ( ( Identifier | operand ) )
            // grammar/AsmY86.g:152:4: ( Identifier | operand )
            {
            // grammar/AsmY86.g:152:4: ( Identifier | operand )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Identifier) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=14 && LA6_0<=50)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // grammar/AsmY86.g:152:5: Identifier
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_label122); 

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:152:18: operand
                    {
                    pushFollow(FOLLOW_operand_in_label126);
                    operand();

                    state._fsp--;


                    }
                    break;

            }

            retval.value = getLabelValue (input.toString(retval.start,input.LT(-1)));

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "label"


    // $ANTLR start "instruction"
    // grammar/AsmY86.g:155:1: instruction : ( nop | halt | rrmovxx | irmovl | rmmovl | mrmovl | opl | jxx | call | ret | pushl | popl | iopl | leave | jmp ) ;
    public final void instruction() throws RecognitionException {
        try {
            // grammar/AsmY86.g:156:2: ( ( nop | halt | rrmovxx | irmovl | rmmovl | mrmovl | opl | jxx | call | ret | pushl | popl | iopl | leave | jmp ) )
            // grammar/AsmY86.g:156:4: ( nop | halt | rrmovxx | irmovl | rmmovl | mrmovl | opl | jxx | call | ret | pushl | popl | iopl | leave | jmp )
            {
            // grammar/AsmY86.g:156:4: ( nop | halt | rrmovxx | irmovl | rmmovl | mrmovl | opl | jxx | call | ret | pushl | popl | iopl | leave | jmp )
            int alt7=15;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // grammar/AsmY86.g:156:5: nop
                    {
                    pushFollow(FOLLOW_nop_in_instruction140);
                    nop();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:156:11: halt
                    {
                    pushFollow(FOLLOW_halt_in_instruction144);
                    halt();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // grammar/AsmY86.g:156:18: rrmovxx
                    {
                    pushFollow(FOLLOW_rrmovxx_in_instruction148);
                    rrmovxx();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // grammar/AsmY86.g:156:28: irmovl
                    {
                    pushFollow(FOLLOW_irmovl_in_instruction152);
                    irmovl();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // grammar/AsmY86.g:156:37: rmmovl
                    {
                    pushFollow(FOLLOW_rmmovl_in_instruction156);
                    rmmovl();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // grammar/AsmY86.g:156:46: mrmovl
                    {
                    pushFollow(FOLLOW_mrmovl_in_instruction160);
                    mrmovl();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // grammar/AsmY86.g:156:55: opl
                    {
                    pushFollow(FOLLOW_opl_in_instruction164);
                    opl();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // grammar/AsmY86.g:156:61: jxx
                    {
                    pushFollow(FOLLOW_jxx_in_instruction168);
                    jxx();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // grammar/AsmY86.g:156:67: call
                    {
                    pushFollow(FOLLOW_call_in_instruction172);
                    call();

                    state._fsp--;


                    }
                    break;
                case 10 :
                    // grammar/AsmY86.g:156:74: ret
                    {
                    pushFollow(FOLLOW_ret_in_instruction176);
                    ret();

                    state._fsp--;


                    }
                    break;
                case 11 :
                    // grammar/AsmY86.g:156:80: pushl
                    {
                    pushFollow(FOLLOW_pushl_in_instruction180);
                    pushl();

                    state._fsp--;


                    }
                    break;
                case 12 :
                    // grammar/AsmY86.g:156:88: popl
                    {
                    pushFollow(FOLLOW_popl_in_instruction184);
                    popl();

                    state._fsp--;


                    }
                    break;
                case 13 :
                    // grammar/AsmY86.g:156:95: iopl
                    {
                    pushFollow(FOLLOW_iopl_in_instruction188);
                    iopl();

                    state._fsp--;


                    }
                    break;
                case 14 :
                    // grammar/AsmY86.g:156:102: leave
                    {
                    pushFollow(FOLLOW_leave_in_instruction192);
                    leave();

                    state._fsp--;


                    }
                    break;
                case 15 :
                    // grammar/AsmY86.g:156:110: jmp
                    {
                    pushFollow(FOLLOW_jmp_in_instruction196);
                    jmp();

                    state._fsp--;


                    }
                    break;

            }

            lineType = LineType.INSTRUCTION;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "instruction"


    // $ANTLR start "operand"
    // grammar/AsmY86.g:158:1: operand : ( 'halt' | 'nop' | 'rrmovl' | 'cmovle' | 'cmovl' | 'cmove' | 'cmovne' | 'cmovge' | 'cmovg' | 'irmovl' | 'rmmovl' | 'mrmovl' | 'addl' | 'subl' | 'andl' | 'xorl' | 'mull' | 'divl' | 'modl' | 'iaddl' | 'isubl' | 'iandl' | 'ixorl' | 'imull' | 'idivl' | 'imodl' | 'jmp' | 'jle' | 'jl' | 'je' | 'jne' | 'jge' | 'jg' | 'call' | 'pushl' | 'popl' | 'leave' ) ;
    public final void operand() throws RecognitionException {
        try {
            // grammar/AsmY86.g:158:9: ( ( 'halt' | 'nop' | 'rrmovl' | 'cmovle' | 'cmovl' | 'cmove' | 'cmovne' | 'cmovge' | 'cmovg' | 'irmovl' | 'rmmovl' | 'mrmovl' | 'addl' | 'subl' | 'andl' | 'xorl' | 'mull' | 'divl' | 'modl' | 'iaddl' | 'isubl' | 'iandl' | 'ixorl' | 'imull' | 'idivl' | 'imodl' | 'jmp' | 'jle' | 'jl' | 'je' | 'jne' | 'jge' | 'jg' | 'call' | 'pushl' | 'popl' | 'leave' ) )
            // grammar/AsmY86.g:158:11: ( 'halt' | 'nop' | 'rrmovl' | 'cmovle' | 'cmovl' | 'cmove' | 'cmovne' | 'cmovge' | 'cmovg' | 'irmovl' | 'rmmovl' | 'mrmovl' | 'addl' | 'subl' | 'andl' | 'xorl' | 'mull' | 'divl' | 'modl' | 'iaddl' | 'isubl' | 'iandl' | 'ixorl' | 'imull' | 'idivl' | 'imodl' | 'jmp' | 'jle' | 'jl' | 'je' | 'jne' | 'jge' | 'jg' | 'call' | 'pushl' | 'popl' | 'leave' )
            {
            if ( (input.LA(1)>=14 && input.LA(1)<=50) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "operand"


    // $ANTLR start "halt"
    // grammar/AsmY86.g:163:1: halt : 'halt' ;
    public final void halt() throws RecognitionException {
        try {
            // grammar/AsmY86.g:163:6: ( 'halt' )
            // grammar/AsmY86.g:163:8: 'halt'
            {
            match(input,14,FOLLOW_14_in_halt379); 
            opCode = 0x00;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "halt"


    // $ANTLR start "nop"
    // grammar/AsmY86.g:164:1: nop : 'nop' ;
    public final void nop() throws RecognitionException {
        try {
            // grammar/AsmY86.g:164:5: ( 'nop' )
            // grammar/AsmY86.g:164:7: 'nop'
            {
            match(input,15,FOLLOW_15_in_nop388); 
            opCode = 0x10;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "nop"


    // $ANTLR start "rrmovxx"
    // grammar/AsmY86.g:165:1: rrmovxx : ( 'rrmovl' | 'cmovle' | 'cmovl' | 'cmove' | 'cmovne' | 'cmovge' | 'cmovg' ) src= register ',' dst= register ;
    public final void rrmovxx() throws RecognitionException {
        int src = 0;

        int dst = 0;


        try {
            // grammar/AsmY86.g:165:9: ( ( 'rrmovl' | 'cmovle' | 'cmovl' | 'cmove' | 'cmovne' | 'cmovge' | 'cmovg' ) src= register ',' dst= register )
            // grammar/AsmY86.g:165:11: ( 'rrmovl' | 'cmovle' | 'cmovl' | 'cmove' | 'cmovne' | 'cmovge' | 'cmovg' ) src= register ',' dst= register
            {
            // grammar/AsmY86.g:165:11: ( 'rrmovl' | 'cmovle' | 'cmovl' | 'cmove' | 'cmovne' | 'cmovge' | 'cmovg' )
            int alt8=7;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt8=1;
                }
                break;
            case 17:
                {
                alt8=2;
                }
                break;
            case 18:
                {
                alt8=3;
                }
                break;
            case 19:
                {
                alt8=4;
                }
                break;
            case 20:
                {
                alt8=5;
                }
                break;
            case 21:
                {
                alt8=6;
                }
                break;
            case 22:
                {
                alt8=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // grammar/AsmY86.g:165:12: 'rrmovl'
                    {
                    match(input,16,FOLLOW_16_in_rrmovxx398); 
                    opCode=0x20;

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:165:38: 'cmovle'
                    {
                    match(input,17,FOLLOW_17_in_rrmovxx404); 
                    opCode=0x21;

                    }
                    break;
                case 3 :
                    // grammar/AsmY86.g:165:64: 'cmovl'
                    {
                    match(input,18,FOLLOW_18_in_rrmovxx410); 
                    opCode=0x22;

                    }
                    break;
                case 4 :
                    // grammar/AsmY86.g:165:89: 'cmove'
                    {
                    match(input,19,FOLLOW_19_in_rrmovxx416); 
                    opCode=0x23;

                    }
                    break;
                case 5 :
                    // grammar/AsmY86.g:165:114: 'cmovne'
                    {
                    match(input,20,FOLLOW_20_in_rrmovxx422); 
                    opCode=0x24;

                    }
                    break;
                case 6 :
                    // grammar/AsmY86.g:166:4: 'cmovge'
                    {
                    match(input,21,FOLLOW_21_in_rrmovxx431); 
                    opCode=0x25;

                    }
                    break;
                case 7 :
                    // grammar/AsmY86.g:166:30: 'cmovg'
                    {
                    match(input,22,FOLLOW_22_in_rrmovxx437); 
                    opCode=0x26;

                    }
                    break;

            }

            pushFollow(FOLLOW_register_in_rrmovxx444);
            src=register();

            state._fsp--;

            match(input,51,FOLLOW_51_in_rrmovxx446); 
            pushFollow(FOLLOW_register_in_rrmovxx450);
            dst=register();

            state._fsp--;

            op[0]=src; op[1]=dst;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rrmovxx"


    // $ANTLR start "irmovl"
    // grammar/AsmY86.g:167:1: irmovl : 'irmovl' immediate ',' register ;
    public final void irmovl() throws RecognitionException {
        int register2 = 0;

        int immediate3 = 0;


        try {
            // grammar/AsmY86.g:167:8: ( 'irmovl' immediate ',' register )
            // grammar/AsmY86.g:167:10: 'irmovl' immediate ',' register
            {
            match(input,23,FOLLOW_23_in_irmovl459); 
            pushFollow(FOLLOW_immediate_in_irmovl461);
            immediate3=immediate();

            state._fsp--;

            match(input,51,FOLLOW_51_in_irmovl463); 
            pushFollow(FOLLOW_register_in_irmovl465);
            register2=register();

            state._fsp--;

             opCode = 0x30; op[0]=0xf; op[1]=register2; op[2]=immediate3; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "irmovl"


    // $ANTLR start "rmmovl"
    // grammar/AsmY86.g:168:1: rmmovl : 'rmmovl' register ',' baseOffset ;
    public final void rmmovl() throws RecognitionException {
        AsmY86Parser.baseOffset_return baseOffset4 = null;

        int register5 = 0;


        try {
            // grammar/AsmY86.g:168:9: ( 'rmmovl' register ',' baseOffset )
            // grammar/AsmY86.g:168:11: 'rmmovl' register ',' baseOffset
            {
            match(input,24,FOLLOW_24_in_rmmovl475); 
            pushFollow(FOLLOW_register_in_rmmovl477);
            register5=register();

            state._fsp--;

            match(input,51,FOLLOW_51_in_rmmovl479); 
            pushFollow(FOLLOW_baseOffset_in_rmmovl480);
            baseOffset4=baseOffset();

            state._fsp--;

             opCode = 0x40+(baseOffset4!=null?baseOffset4.scale:0); op[0]=register5; op[1]=(baseOffset4!=null?baseOffset4.base:0); op[2]=(baseOffset4!=null?baseOffset4.offset:0); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rmmovl"


    // $ANTLR start "mrmovl"
    // grammar/AsmY86.g:169:1: mrmovl : 'mrmovl' baseOffset ',' register ;
    public final void mrmovl() throws RecognitionException {
        AsmY86Parser.baseOffset_return baseOffset6 = null;

        int register7 = 0;


        try {
            // grammar/AsmY86.g:169:8: ( 'mrmovl' baseOffset ',' register )
            // grammar/AsmY86.g:169:10: 'mrmovl' baseOffset ',' register
            {
            match(input,25,FOLLOW_25_in_mrmovl489); 
            pushFollow(FOLLOW_baseOffset_in_mrmovl491);
            baseOffset6=baseOffset();

            state._fsp--;

            match(input,51,FOLLOW_51_in_mrmovl493); 
            pushFollow(FOLLOW_register_in_mrmovl495);
            register7=register();

            state._fsp--;

             opCode = 0x50+(baseOffset6!=null?baseOffset6.scale:0); op[0]=register7; op[1]=(baseOffset6!=null?baseOffset6.base:0); op[2]=(baseOffset6!=null?baseOffset6.offset:0); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "mrmovl"


    // $ANTLR start "opl"
    // grammar/AsmY86.g:170:1: opl : ( 'addl' | 'subl' | 'andl' | 'xorl' | 'mull' | 'divl' | 'modl' ) a= register ',' b= register ;
    public final void opl() throws RecognitionException {
        int a = 0;

        int b = 0;


        try {
            // grammar/AsmY86.g:170:5: ( ( 'addl' | 'subl' | 'andl' | 'xorl' | 'mull' | 'divl' | 'modl' ) a= register ',' b= register )
            // grammar/AsmY86.g:170:7: ( 'addl' | 'subl' | 'andl' | 'xorl' | 'mull' | 'divl' | 'modl' ) a= register ',' b= register
            {
            // grammar/AsmY86.g:170:7: ( 'addl' | 'subl' | 'andl' | 'xorl' | 'mull' | 'divl' | 'modl' )
            int alt9=7;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt9=1;
                }
                break;
            case 27:
                {
                alt9=2;
                }
                break;
            case 28:
                {
                alt9=3;
                }
                break;
            case 29:
                {
                alt9=4;
                }
                break;
            case 30:
                {
                alt9=5;
                }
                break;
            case 31:
                {
                alt9=6;
                }
                break;
            case 32:
                {
                alt9=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // grammar/AsmY86.g:170:8: 'addl'
                    {
                    match(input,26,FOLLOW_26_in_opl505); 
                    opCode=0x60 + AbstractY86CPU.A_ADDL;

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:170:56: 'subl'
                    {
                    match(input,27,FOLLOW_27_in_opl511); 
                    opCode=0x60 + AbstractY86CPU.A_SUBL;

                    }
                    break;
                case 3 :
                    // grammar/AsmY86.g:170:104: 'andl'
                    {
                    match(input,28,FOLLOW_28_in_opl517); 
                    opCode=0x60 + AbstractY86CPU.A_ANDL;

                    }
                    break;
                case 4 :
                    // grammar/AsmY86.g:170:152: 'xorl'
                    {
                    match(input,29,FOLLOW_29_in_opl523); 
                    opCode=0x60 + AbstractY86CPU.A_XORL;

                    }
                    break;
                case 5 :
                    // grammar/AsmY86.g:170:200: 'mull'
                    {
                    match(input,30,FOLLOW_30_in_opl529); 
                    opCode=0x60 + AbstractY86CPU.A_MULL;

                    }
                    break;
                case 6 :
                    // grammar/AsmY86.g:170:248: 'divl'
                    {
                    match(input,31,FOLLOW_31_in_opl535); 
                    opCode=0x60 + AbstractY86CPU.A_DIVL;

                    }
                    break;
                case 7 :
                    // grammar/AsmY86.g:170:296: 'modl'
                    {
                    match(input,32,FOLLOW_32_in_opl541); 
                    opCode=0x60 + AbstractY86CPU.A_MODL;

                    }
                    break;

            }

            pushFollow(FOLLOW_register_in_opl551);
            a=register();

            state._fsp--;

            match(input,51,FOLLOW_51_in_opl553); 
            pushFollow(FOLLOW_register_in_opl557);
            b=register();

            state._fsp--;

            op[0]=a; op[1]=b;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "opl"


    // $ANTLR start "iopl"
    // grammar/AsmY86.g:172:1: iopl : ( 'iaddl' | 'isubl' | 'iandl' | 'ixorl' | 'imull' | 'idivl' | 'imodl' ) immediate ',' register ;
    public final void iopl() throws RecognitionException {
        int register8 = 0;

        int immediate9 = 0;


        try {
            // grammar/AsmY86.g:172:6: ( ( 'iaddl' | 'isubl' | 'iandl' | 'ixorl' | 'imull' | 'idivl' | 'imodl' ) immediate ',' register )
            // grammar/AsmY86.g:172:8: ( 'iaddl' | 'isubl' | 'iandl' | 'ixorl' | 'imull' | 'idivl' | 'imodl' ) immediate ',' register
            {
            // grammar/AsmY86.g:172:8: ( 'iaddl' | 'isubl' | 'iandl' | 'ixorl' | 'imull' | 'idivl' | 'imodl' )
            int alt10=7;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt10=1;
                }
                break;
            case 34:
                {
                alt10=2;
                }
                break;
            case 35:
                {
                alt10=3;
                }
                break;
            case 36:
                {
                alt10=4;
                }
                break;
            case 37:
                {
                alt10=5;
                }
                break;
            case 38:
                {
                alt10=6;
                }
                break;
            case 39:
                {
                alt10=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // grammar/AsmY86.g:172:9: 'iaddl'
                    {
                    match(input,33,FOLLOW_33_in_iopl567); 
                    opCode=0xc0 + AbstractY86CPU.A_ADDL;

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:172:58: 'isubl'
                    {
                    match(input,34,FOLLOW_34_in_iopl573); 
                    opCode=0xc0 + AbstractY86CPU.A_SUBL;

                    }
                    break;
                case 3 :
                    // grammar/AsmY86.g:172:107: 'iandl'
                    {
                    match(input,35,FOLLOW_35_in_iopl579); 
                    opCode=0xc0 + AbstractY86CPU.A_ANDL;

                    }
                    break;
                case 4 :
                    // grammar/AsmY86.g:172:156: 'ixorl'
                    {
                    match(input,36,FOLLOW_36_in_iopl585); 
                    opCode=0xc0 + AbstractY86CPU.A_XORL;

                    }
                    break;
                case 5 :
                    // grammar/AsmY86.g:172:205: 'imull'
                    {
                    match(input,37,FOLLOW_37_in_iopl591); 
                    opCode=0xc0 + AbstractY86CPU.A_MULL;

                    }
                    break;
                case 6 :
                    // grammar/AsmY86.g:172:254: 'idivl'
                    {
                    match(input,38,FOLLOW_38_in_iopl597); 
                    opCode=0xc0 + AbstractY86CPU.A_DIVL;

                    }
                    break;
                case 7 :
                    // grammar/AsmY86.g:172:303: 'imodl'
                    {
                    match(input,39,FOLLOW_39_in_iopl603); 
                    opCode=0xc0 + AbstractY86CPU.A_MODL;

                    }
                    break;

            }

            pushFollow(FOLLOW_immediate_in_iopl611);
            immediate9=immediate();

            state._fsp--;

            match(input,51,FOLLOW_51_in_iopl613); 
            pushFollow(FOLLOW_register_in_iopl615);
            register8=register();

            state._fsp--;

            op[0]=0xf; op[1]=register8; op[2]=immediate9;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "iopl"


    // $ANTLR start "jxx"
    // grammar/AsmY86.g:174:1: jxx : ( 'jmp' | 'jle' | 'jl' | 'je' | 'jne' | 'jge' | 'jg' ) literal ;
    public final void jxx() throws RecognitionException {
        int literal10 = 0;


        try {
            // grammar/AsmY86.g:174:5: ( ( 'jmp' | 'jle' | 'jl' | 'je' | 'jne' | 'jge' | 'jg' ) literal )
            // grammar/AsmY86.g:174:7: ( 'jmp' | 'jle' | 'jl' | 'je' | 'jne' | 'jge' | 'jg' ) literal
            {
            // grammar/AsmY86.g:174:7: ( 'jmp' | 'jle' | 'jl' | 'je' | 'jne' | 'jge' | 'jg' )
            int alt11=7;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt11=1;
                }
                break;
            case 41:
                {
                alt11=2;
                }
                break;
            case 42:
                {
                alt11=3;
                }
                break;
            case 43:
                {
                alt11=4;
                }
                break;
            case 44:
                {
                alt11=5;
                }
                break;
            case 45:
                {
                alt11=6;
                }
                break;
            case 46:
                {
                alt11=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // grammar/AsmY86.g:174:8: 'jmp'
                    {
                    match(input,40,FOLLOW_40_in_jxx625); 
                    opCode=0x70;

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:174:31: 'jle'
                    {
                    match(input,41,FOLLOW_41_in_jxx631); 
                    opCode=0x71;

                    }
                    break;
                case 3 :
                    // grammar/AsmY86.g:174:54: 'jl'
                    {
                    match(input,42,FOLLOW_42_in_jxx637); 
                    opCode=0x72;

                    }
                    break;
                case 4 :
                    // grammar/AsmY86.g:174:76: 'je'
                    {
                    match(input,43,FOLLOW_43_in_jxx643); 
                    opCode=0x73;

                    }
                    break;
                case 5 :
                    // grammar/AsmY86.g:175:4: 'jne'
                    {
                    match(input,44,FOLLOW_44_in_jxx653); 
                    opCode=0x74;

                    }
                    break;
                case 6 :
                    // grammar/AsmY86.g:175:27: 'jge'
                    {
                    match(input,45,FOLLOW_45_in_jxx659); 
                    opCode=0x75;

                    }
                    break;
                case 7 :
                    // grammar/AsmY86.g:175:50: 'jg'
                    {
                    match(input,46,FOLLOW_46_in_jxx665); 
                    opCode=0x76;

                    }
                    break;

            }

            pushFollow(FOLLOW_literal_in_jxx674);
            literal10=literal();

            state._fsp--;

             op[0] = literal10;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "jxx"


    // $ANTLR start "call"
    // grammar/AsmY86.g:177:1: call : 'call' ( literal | a= regIndirect | '*' b= regIndirect ) ;
    public final void call() throws RecognitionException {
        int a = 0;

        int b = 0;

        int literal11 = 0;


        try {
            // grammar/AsmY86.g:177:6: ( 'call' ( literal | a= regIndirect | '*' b= regIndirect ) )
            // grammar/AsmY86.g:177:8: 'call' ( literal | a= regIndirect | '*' b= regIndirect )
            {
            match(input,47,FOLLOW_47_in_call683); 
            // grammar/AsmY86.g:177:15: ( literal | a= regIndirect | '*' b= regIndirect )
            int alt12=3;
            switch ( input.LA(1) ) {
            case Identifier:
            case Hex:
            case Decimal:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 65:
                {
                alt12=1;
                }
                break;
            case 55:
                {
                alt12=2;
                }
                break;
            case 52:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // grammar/AsmY86.g:177:16: literal
                    {
                    pushFollow(FOLLOW_literal_in_call686);
                    literal11=literal();

                    state._fsp--;

                    opCode=0x80; op[0]=literal11;

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:178:4: a= regIndirect
                    {
                    pushFollow(FOLLOW_regIndirect_in_call698);
                    a=regIndirect();

                    state._fsp--;

                    opCode=0xf0; op[0]=a; op[1]=0xf;

                    }
                    break;
                case 3 :
                    // grammar/AsmY86.g:179:4: '*' b= regIndirect
                    {
                    match(input,52,FOLLOW_52_in_call707); 
                    pushFollow(FOLLOW_regIndirect_in_call711);
                    b=regIndirect();

                    state._fsp--;

                    opCode=0xf1; op[0]=b; op[1]=0xf;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "call"


    // $ANTLR start "ret"
    // grammar/AsmY86.g:180:1: ret : 'ret' ;
    public final void ret() throws RecognitionException {
        try {
            // grammar/AsmY86.g:180:5: ( 'ret' )
            // grammar/AsmY86.g:180:7: 'ret'
            {
            match(input,53,FOLLOW_53_in_ret721); 
            opCode=0x90;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ret"


    // $ANTLR start "pushl"
    // grammar/AsmY86.g:181:1: pushl : 'pushl' register ;
    public final void pushl() throws RecognitionException {
        int register12 = 0;


        try {
            // grammar/AsmY86.g:181:7: ( 'pushl' register )
            // grammar/AsmY86.g:181:9: 'pushl' register
            {
            match(input,48,FOLLOW_48_in_pushl730); 
            pushFollow(FOLLOW_register_in_pushl732);
            register12=register();

            state._fsp--;

            opCode=0xa0; op[0] = register12; op[1]=0xf;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pushl"


    // $ANTLR start "popl"
    // grammar/AsmY86.g:182:1: popl : 'popl' register ;
    public final void popl() throws RecognitionException {
        int register13 = 0;


        try {
            // grammar/AsmY86.g:182:6: ( 'popl' register )
            // grammar/AsmY86.g:182:8: 'popl' register
            {
            match(input,49,FOLLOW_49_in_popl741); 
            pushFollow(FOLLOW_register_in_popl743);
            register13=register();

            state._fsp--;

            opCode=0xb0; op[0] = register13; op[1]=0xf;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "popl"


    // $ANTLR start "leave"
    // grammar/AsmY86.g:183:1: leave : 'leave' ;
    public final void leave() throws RecognitionException {
        try {
            // grammar/AsmY86.g:183:7: ( 'leave' )
            // grammar/AsmY86.g:183:9: 'leave'
            {
            match(input,50,FOLLOW_50_in_leave752); 
            opCode = 0xd0;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "leave"


    // $ANTLR start "jmp"
    // grammar/AsmY86.g:184:1: jmp : 'jmp' (a= baseOffset | '*' b= baseOffset ) ;
    public final void jmp() throws RecognitionException {
        AsmY86Parser.baseOffset_return a = null;

        AsmY86Parser.baseOffset_return b = null;


        try {
            // grammar/AsmY86.g:184:5: ( 'jmp' (a= baseOffset | '*' b= baseOffset ) )
            // grammar/AsmY86.g:184:7: 'jmp' (a= baseOffset | '*' b= baseOffset )
            {
            match(input,40,FOLLOW_40_in_jmp761); 
            // grammar/AsmY86.g:184:13: (a= baseOffset | '*' b= baseOffset )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=Identifier && LA13_0<=Decimal)||(LA13_0>=14 && LA13_0<=50)||LA13_0==55||LA13_0==65) ) {
                alt13=1;
            }
            else if ( (LA13_0==52) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // grammar/AsmY86.g:184:14: a= baseOffset
                    {
                    pushFollow(FOLLOW_baseOffset_in_jmp766);
                    a=baseOffset();

                    state._fsp--;

                    opCode=0xe0; op[0]=0xf; op[1]=(a!=null?a.base:0); op[2]=(a!=null?a.offset:0);

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:185:10: '*' b= baseOffset
                    {
                    match(input,52,FOLLOW_52_in_jmp781); 
                    pushFollow(FOLLOW_baseOffset_in_jmp785);
                    b=baseOffset();

                    state._fsp--;

                    opCode=0xe1; op[0]=0xf; op[1]=(b!=null?b.base:0); op[2]=(b!=null?b.offset:0);

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "jmp"


    // $ANTLR start "immediate"
    // grammar/AsmY86.g:187:1: immediate returns [int value] : ( ( '$' )? label | ( '$' )? number );
    public final int immediate() throws RecognitionException {
        int value = 0;

        AsmY86Parser.label_return label14 = null;

        int number15 = 0;


        try {
            // grammar/AsmY86.g:188:2: ( ( '$' )? label | ( '$' )? number )
            int alt16=2;
            switch ( input.LA(1) ) {
            case 54:
                {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==Identifier||(LA16_1>=14 && LA16_1<=50)) ) {
                    alt16=1;
                }
                else if ( ((LA16_1>=Hex && LA16_1<=Decimal)||LA16_1==65) ) {
                    alt16=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
                }
                break;
            case Identifier:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
                {
                alt16=1;
                }
                break;
            case Hex:
            case Decimal:
            case 65:
                {
                alt16=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // grammar/AsmY86.g:188:4: ( '$' )? label
                    {
                    // grammar/AsmY86.g:188:4: ( '$' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==54) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // grammar/AsmY86.g:188:4: '$'
                            {
                            match(input,54,FOLLOW_54_in_immediate801); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_label_in_immediate804);
                    label14=label();

                    state._fsp--;

                    value = (label14!=null?label14.value:0);

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:188:42: ( '$' )? number
                    {
                    // grammar/AsmY86.g:188:42: ( '$' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==54) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // grammar/AsmY86.g:188:42: '$'
                            {
                            match(input,54,FOLLOW_54_in_immediate810); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_number_in_immediate813);
                    number15=number();

                    state._fsp--;

                    value = number15;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "immediate"


    // $ANTLR start "literal"
    // grammar/AsmY86.g:189:1: literal returns [int value] : ( label | number );
    public final int literal() throws RecognitionException {
        int value = 0;

        AsmY86Parser.label_return label16 = null;

        int number17 = 0;


        try {
            // grammar/AsmY86.g:190:2: ( label | number )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Identifier||(LA17_0>=14 && LA17_0<=50)) ) {
                alt17=1;
            }
            else if ( ((LA17_0>=Hex && LA17_0<=Decimal)||LA17_0==65) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // grammar/AsmY86.g:190:4: label
                    {
                    pushFollow(FOLLOW_label_in_literal827);
                    label16=label();

                    state._fsp--;

                    value = (label16!=null?label16.value:0);

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:190:37: number
                    {
                    pushFollow(FOLLOW_number_in_literal833);
                    number17=number();

                    state._fsp--;

                    value = number17;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "literal"

    public static class baseOffset_return extends ParserRuleReturnScope {
        public int offset;
        public int base;
        public int scale;
    };

    // $ANTLR start "baseOffset"
    // grammar/AsmY86.g:191:1: baseOffset returns [int offset, int base, int scale] : ( literal )? regIndirectScale ;
    public final AsmY86Parser.baseOffset_return baseOffset() throws RecognitionException {
        AsmY86Parser.baseOffset_return retval = new AsmY86Parser.baseOffset_return();
        retval.start = input.LT(1);

        int literal18 = 0;

        AsmY86Parser.regIndirectScale_return regIndirectScale19 = null;


        try {
            // grammar/AsmY86.g:192:2: ( ( literal )? regIndirectScale )
            // grammar/AsmY86.g:192:4: ( literal )? regIndirectScale
            {
            // grammar/AsmY86.g:192:4: ( literal )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=Identifier && LA18_0<=Decimal)||(LA18_0>=14 && LA18_0<=50)||LA18_0==65) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // grammar/AsmY86.g:192:4: literal
                    {
                    pushFollow(FOLLOW_literal_in_baseOffset847);
                    literal18=literal();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_regIndirectScale_in_baseOffset850);
            regIndirectScale19=regIndirectScale();

            state._fsp--;

            retval.offset =literal18; retval.base =(regIndirectScale19!=null?regIndirectScale19.value:0); retval.scale =(regIndirectScale19!=null?regIndirectScale19.scale:0);

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "baseOffset"


    // $ANTLR start "regIndirect"
    // grammar/AsmY86.g:193:1: regIndirect returns [int value] : '(' register ')' ;
    public final int regIndirect() throws RecognitionException {
        int value = 0;

        int register20 = 0;


        try {
            // grammar/AsmY86.g:194:2: ( '(' register ')' )
            // grammar/AsmY86.g:194:4: '(' register ')'
            {
            match(input,55,FOLLOW_55_in_regIndirect864); 
            pushFollow(FOLLOW_register_in_regIndirect866);
            register20=register();

            state._fsp--;

            match(input,56,FOLLOW_56_in_regIndirect868); 
            value =register20;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "regIndirect"

    public static class regIndirectScale_return extends ParserRuleReturnScope {
        public int value;
        public int scale;
    };

    // $ANTLR start "regIndirectScale"
    // grammar/AsmY86.g:195:1: regIndirectScale returns [int value, int scale] : '(' register ( ',' scaleLit )? ')' ;
    public final AsmY86Parser.regIndirectScale_return regIndirectScale() throws RecognitionException {
        AsmY86Parser.regIndirectScale_return retval = new AsmY86Parser.regIndirectScale_return();
        retval.start = input.LT(1);

        int register21 = 0;

        Integer scaleLit22 = null;


        try {
            // grammar/AsmY86.g:196:9: ( '(' register ( ',' scaleLit )? ')' )
            // grammar/AsmY86.g:196:11: '(' register ( ',' scaleLit )? ')'
            {
            match(input,55,FOLLOW_55_in_regIndirectScale889); 
            pushFollow(FOLLOW_register_in_regIndirectScale891);
            register21=register();

            state._fsp--;

            // grammar/AsmY86.g:196:24: ( ',' scaleLit )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==51) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // grammar/AsmY86.g:196:25: ',' scaleLit
                    {
                    match(input,51,FOLLOW_51_in_regIndirectScale894); 
                    pushFollow(FOLLOW_scaleLit_in_regIndirectScale896);
                    scaleLit22=scaleLit();

                    state._fsp--;


                    }
                    break;

            }

            match(input,56,FOLLOW_56_in_regIndirectScale901); 
            retval.value =register21; retval.scale =scaleLit22!=null? scaleLit22 : 0;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "regIndirectScale"


    // $ANTLR start "scaleLit"
    // grammar/AsmY86.g:197:1: scaleLit returns [Integer value] : decimal ;
    public final Integer scaleLit() throws RecognitionException {
        Integer value = null;

        int decimal23 = 0;


        try {
            // grammar/AsmY86.g:198:9: ( decimal )
            // grammar/AsmY86.g:198:11: decimal
            {
            pushFollow(FOLLOW_decimal_in_scaleLit922);
            decimal23=decimal();

            state._fsp--;

             value = decimal23; if (value != 1 && value != 2 && value != 4) { throw new Assembler.AssemblyException("Illegal scale in mrmovl/rmmovl"); } 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "scaleLit"


    // $ANTLR start "register"
    // grammar/AsmY86.g:200:1: register returns [int value] : ( '%eax' | '%ecx' | '%edx' | '%ebx' | '%esp' | '%ebp' | '%esi' | '%edi' );
    public final int register() throws RecognitionException {
        int value = 0;

        try {
            // grammar/AsmY86.g:201:2: ( '%eax' | '%ecx' | '%edx' | '%ebx' | '%esp' | '%ebp' | '%esi' | '%edi' )
            int alt20=8;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt20=1;
                }
                break;
            case 58:
                {
                alt20=2;
                }
                break;
            case 59:
                {
                alt20=3;
                }
                break;
            case 60:
                {
                alt20=4;
                }
                break;
            case 61:
                {
                alt20=5;
                }
                break;
            case 62:
                {
                alt20=6;
                }
                break;
            case 63:
                {
                alt20=7;
                }
                break;
            case 64:
                {
                alt20=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // grammar/AsmY86.g:201:4: '%eax'
                    {
                    match(input,57,FOLLOW_57_in_register938); 
                    value = 0;

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:201:27: '%ecx'
                    {
                    match(input,58,FOLLOW_58_in_register944); 
                    value = 1;

                    }
                    break;
                case 3 :
                    // grammar/AsmY86.g:201:50: '%edx'
                    {
                    match(input,59,FOLLOW_59_in_register950); 
                    value = 2;

                    }
                    break;
                case 4 :
                    // grammar/AsmY86.g:201:73: '%ebx'
                    {
                    match(input,60,FOLLOW_60_in_register956); 
                    value = 3;

                    }
                    break;
                case 5 :
                    // grammar/AsmY86.g:201:96: '%esp'
                    {
                    match(input,61,FOLLOW_61_in_register962); 
                    value = 4;

                    }
                    break;
                case 6 :
                    // grammar/AsmY86.g:202:3: '%ebp'
                    {
                    match(input,62,FOLLOW_62_in_register971); 
                    value = 5;

                    }
                    break;
                case 7 :
                    // grammar/AsmY86.g:202:26: '%esi'
                    {
                    match(input,63,FOLLOW_63_in_register977); 
                    value = 6;

                    }
                    break;
                case 8 :
                    // grammar/AsmY86.g:202:49: '%edi'
                    {
                    match(input,64,FOLLOW_64_in_register983); 
                    value = 7;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "register"


    // $ANTLR start "number"
    // grammar/AsmY86.g:203:1: number returns [int value] : ( '-' )? ( decimal | hex ) ;
    public final int number() throws RecognitionException {
        int value = 0;

        int decimal24 = 0;

        int hex25 = 0;


        try {
            // grammar/AsmY86.g:204:3: ( ( '-' )? ( decimal | hex ) )
            // grammar/AsmY86.g:204:5: ( '-' )? ( decimal | hex )
            {
            value = 1;
            // grammar/AsmY86.g:204:19: ( '-' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==65) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // grammar/AsmY86.g:204:20: '-'
                    {
                    match(input,65,FOLLOW_65_in_number1001); 
                    value = -1;

                    }
                    break;

            }

            // grammar/AsmY86.g:204:41: ( decimal | hex )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Decimal) ) {
                alt22=1;
            }
            else if ( (LA22_0==Hex) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // grammar/AsmY86.g:204:43: decimal
                    {
                    pushFollow(FOLLOW_decimal_in_number1009);
                    decimal24=decimal();

                    state._fsp--;

                    value*=decimal24; 

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:204:80: hex
                    {
                    pushFollow(FOLLOW_hex_in_number1015);
                    hex25=hex();

                    state._fsp--;

                    value*=hex25;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "number"


    // $ANTLR start "hex"
    // grammar/AsmY86.g:205:1: hex returns [int value] : Hex ;
    public final int hex() throws RecognitionException {
        int value = 0;

        Token Hex26=null;

        try {
            // grammar/AsmY86.g:206:2: ( Hex )
            // grammar/AsmY86.g:206:4: Hex
            {
            Hex26=(Token)match(input,Hex,FOLLOW_Hex_in_hex1031); 
            value =(int)(Long.parseLong((Hex26!=null?Hex26.getText():null).substring(2),16));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "hex"


    // $ANTLR start "decimal"
    // grammar/AsmY86.g:208:1: decimal returns [int value] : Decimal ;
    public final int decimal() throws RecognitionException {
        int value = 0;

        Token Decimal27=null;

        try {
            // grammar/AsmY86.g:209:3: ( Decimal )
            // grammar/AsmY86.g:209:5: Decimal
            {
            Decimal27=(Token)match(input,Decimal,FOLLOW_Decimal_in_decimal1049); 
            value =(int)(Long.parseLong((Decimal27!=null?Decimal27.getText():null)));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "decimal"


    // $ANTLR start "directive"
    // grammar/AsmY86.g:211:1: directive : ( pos | data | align );
    public final void directive() throws RecognitionException {
        try {
            // grammar/AsmY86.g:212:2: ( pos | data | align )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt23=1;
                }
                break;
            case 67:
            case 68:
            case 69:
                {
                alt23=2;
                }
                break;
            case 70:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // grammar/AsmY86.g:212:4: pos
                    {
                    pushFollow(FOLLOW_pos_in_directive1066);
                    pos();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:212:10: data
                    {
                    pushFollow(FOLLOW_data_in_directive1070);
                    data();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // grammar/AsmY86.g:212:17: align
                    {
                    pushFollow(FOLLOW_align_in_directive1074);
                    align();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "directive"


    // $ANTLR start "pos"
    // grammar/AsmY86.g:213:1: pos : ( '.pos' number ) ;
    public final void pos() throws RecognitionException {
        int number28 = 0;


        try {
            // grammar/AsmY86.g:213:5: ( ( '.pos' number ) )
            // grammar/AsmY86.g:213:7: ( '.pos' number )
            {
            // grammar/AsmY86.g:213:7: ( '.pos' number )
            // grammar/AsmY86.g:213:8: '.pos' number
            {
            match(input,66,FOLLOW_66_in_pos1082); 
            pushFollow(FOLLOW_number_in_pos1084);
            number28=number();

            state._fsp--;

            pc = number28;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pos"


    // $ANTLR start "data"
    // grammar/AsmY86.g:214:1: data : ( '.long' | '.word' | '.byte' ) literal ( ',' count= number )? ;
    public final void data() throws RecognitionException {
        int count = 0;

        int literal29 = 0;


        try {
            // grammar/AsmY86.g:214:6: ( ( '.long' | '.word' | '.byte' ) literal ( ',' count= number )? )
            // grammar/AsmY86.g:214:8: ( '.long' | '.word' | '.byte' ) literal ( ',' count= number )?
            {
            // grammar/AsmY86.g:214:8: ( '.long' | '.word' | '.byte' )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt24=1;
                }
                break;
            case 68:
                {
                alt24=2;
                }
                break;
            case 69:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // grammar/AsmY86.g:214:9: '.long'
                    {
                    match(input,67,FOLLOW_67_in_data1095); 
                    dataSize=4;

                    }
                    break;
                case 2 :
                    // grammar/AsmY86.g:214:33: '.word'
                    {
                    match(input,68,FOLLOW_68_in_data1101); 
                    dataSize=2;

                    }
                    break;
                case 3 :
                    // grammar/AsmY86.g:214:57: '.byte'
                    {
                    match(input,69,FOLLOW_69_in_data1107); 
                    dataSize=1;

                    }
                    break;

            }

            pushFollow(FOLLOW_literal_in_data1112);
            literal29=literal();

            state._fsp--;

            dataValue=literal29;
            // grammar/AsmY86.g:214:116: ( ',' count= number )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==51) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // grammar/AsmY86.g:214:117: ',' count= number
                    {
                    match(input,51,FOLLOW_51_in_data1117); 
                    pushFollow(FOLLOW_number_in_data1121);
                    count=number();

                    state._fsp--;


                    }
                    break;

            }

            lineType = LineType.DATA; dataCount=count>0? count : 1;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "data"


    // $ANTLR start "align"
    // grammar/AsmY86.g:216:1: align : '.align' number ;
    public final void align() throws RecognitionException {
        int number30 = 0;


        try {
            // grammar/AsmY86.g:216:7: ( '.align' number )
            // grammar/AsmY86.g:216:9: '.align' number
            {
            match(input,70,FOLLOW_70_in_align1134); 
            pushFollow(FOLLOW_number_in_align1136);
            number30=number();

            state._fsp--;

            pc = (pc + number30 - 1) / number30 * number30;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "align"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA2_eotS =
        "\50\uffff";
    static final String DFA2_eofS =
        "\50\uffff";
    static final String DFA2_minS =
        "\1\4\1\uffff\2\4\7\15\1\6\1\15\1\6\7\15\10\6\1\15\1\uffff\1\15\7"+
        "\6\1\4";
    static final String DFA2_maxS =
        "\1\106\1\uffff\2\15\7\100\1\101\1\100\1\101\7\100\10\101\1\100\1"+
        "\uffff\1\100\7\101\1\15";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\34\uffff\1\2\11\uffff";
    static final String DFA2_specialS =
        "\50\uffff}>";
    static final String[] DFA2_transitionS = {
            "\2\36\1\1\7\uffff\1\3\1\2\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
            "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\40\1\41\1\42"+
            "\1\43\1\44\1\45\1\46\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
            "\1\35\1\37\1\47\2\uffff\1\36\14\uffff\5\36",
            "",
            "\2\36\7\uffff\1\1",
            "\2\36\7\uffff\1\1",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\3\36\4\uffff\1\1\45\36\3\uffff\1\36\12\uffff\1\36",
            "\1\1\53\uffff\10\36",
            "\3\36\4\uffff\1\1\45\36\4\uffff\1\36\11\uffff\1\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\1\1\53\uffff\10\36",
            "\3\36\4\uffff\1\1\45\36\1\uffff\1\36\2\uffff\1\36\11\uffff"+
            "\1\36",
            "\3\36\4\uffff\1\1\45\36\16\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\16\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\16\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\16\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\16\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\16\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\1\uffff\1\36\2\uffff\1\36\11\uffff"+
            "\1\36",
            "\1\1\53\uffff\10\36",
            "",
            "\1\1\53\uffff\10\36",
            "\3\36\4\uffff\1\1\45\36\3\uffff\1\36\12\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\3\uffff\1\36\12\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\3\uffff\1\36\12\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\3\uffff\1\36\12\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\3\uffff\1\36\12\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\3\uffff\1\36\12\uffff\1\36",
            "\3\36\4\uffff\1\1\45\36\3\uffff\1\36\12\uffff\1\36",
            "\2\36\7\uffff\1\1"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "146:8: ( labelDeclaration )?";
        }
    }
    static final String DFA7_eotS =
        "\26\uffff";
    static final String DFA7_eofS =
        "\26\uffff";
    static final String DFA7_minS =
        "\1\16\7\uffff\1\6\7\uffff\2\4\1\7\2\4\1\uffff";
    static final String DFA7_maxS =
        "\1\65\7\uffff\1\101\7\uffff\2\67\1\10\2\67\1\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\10\1\11\1\12\1\13"+
        "\1\14\1\15\1\16\5\uffff\1\17";
    static final String DFA7_specialS =
        "\26\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\2\1\1\7\3\1\4\1\5\1\6\7\7\7\16\1\10\6\11\1\12\1\14\1\15\1"+
            "\17\2\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20\1\24\1\23\5\uffff\45\21\1\uffff\1\25\2\uffff\1\25\11"+
            "\uffff\1\22",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\11\61\uffff\1\25",
            "\2\11\61\uffff\1\25",
            "\1\24\1\23",
            "\2\11\61\uffff\1\25",
            "\2\11\61\uffff\1\25",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "156:4: ( nop | halt | rrmovxx | irmovl | rmmovl | mrmovl | opl | jxx | call | ret | pushl | popl | iopl | leave | jmp )";
        }
    }
 

    public static final BitSet FOLLOW_line_in_program46 = new BitSet(new long[]{0x0027FFFFFFFFC070L,0x000000000000007CL});
    public static final BitSet FOLLOW_EOF_in_program49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelDeclaration_in_line58 = new BitSet(new long[]{0x0027FFFFFFFFC030L,0x000000000000007CL});
    public static final BitSet FOLLOW_instruction_in_line64 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_directive_in_line68 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_NewLine_in_line75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comment_in_line80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_labelDeclaration100 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_operand_in_labelDeclaration104 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_labelDeclaration107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_label122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operand_in_label126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nop_in_instruction140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_halt_in_instruction144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rrmovxx_in_instruction148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_irmovl_in_instruction152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rmmovl_in_instruction156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mrmovl_in_instruction160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_opl_in_instruction164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jxx_in_instruction168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_in_instruction172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ret_in_instruction176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushl_in_instruction180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_popl_in_instruction184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iopl_in_instruction188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leave_in_instruction192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jmp_in_instruction196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operand209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_halt379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_nop388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rrmovxx398 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_17_in_rrmovxx404 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_18_in_rrmovxx410 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_19_in_rrmovxx416 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_20_in_rrmovxx422 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_21_in_rrmovxx431 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_22_in_rrmovxx437 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_rrmovxx444 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_rrmovxx446 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_rrmovxx450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_irmovl459 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_immediate_in_irmovl461 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_irmovl463 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_irmovl465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rmmovl475 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_rmmovl477 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_rmmovl479 = new BitSet(new long[]{0x00C7FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_baseOffset_in_rmmovl480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_mrmovl489 = new BitSet(new long[]{0x00C7FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_baseOffset_in_mrmovl491 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_mrmovl493 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_mrmovl495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_opl505 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_27_in_opl511 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_28_in_opl517 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_29_in_opl523 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_30_in_opl529 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_31_in_opl535 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_32_in_opl541 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_opl551 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_opl553 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_opl557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_iopl567 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_iopl573 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_iopl579 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_iopl585 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_iopl591 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_iopl597 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_iopl603 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_immediate_in_iopl611 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_iopl613 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_iopl615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_jxx625 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_jxx631 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_jxx637 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_jxx643 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_jxx653 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_jxx659 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_jxx665 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_jxx674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_call683 = new BitSet(new long[]{0x00D7FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_call686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regIndirect_in_call698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_call707 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_regIndirect_in_call711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ret721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_pushl730 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_pushl732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_popl741 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_popl743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_leave752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_jmp761 = new BitSet(new long[]{0x00D7FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_baseOffset_in_jmp766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_jmp781 = new BitSet(new long[]{0x00C7FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_baseOffset_in_jmp785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_immediate801 = new BitSet(new long[]{0x0047FFFFFFFFC040L});
    public static final BitSet FOLLOW_label_in_immediate804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_immediate810 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_number_in_immediate813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_label_in_literal827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_in_literal833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_baseOffset847 = new BitSet(new long[]{0x00C7FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_regIndirectScale_in_baseOffset850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_regIndirect864 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_regIndirect866 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_regIndirect868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_regIndirectScale889 = new BitSet(new long[]{0xFE00000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_register_in_regIndirectScale891 = new BitSet(new long[]{0x0108000000000000L});
    public static final BitSet FOLLOW_51_in_regIndirectScale894 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_scaleLit_in_regIndirectScale896 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_regIndirectScale901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decimal_in_scaleLit922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_register938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_register944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_register950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_register956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_register962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_register971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_register977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_register983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_number1001 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_decimal_in_number1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hex_in_number1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hex_in_hex1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Decimal_in_decimal1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pos_in_directive1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_data_in_directive1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_align_in_directive1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_pos1082 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_number_in_pos1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_data1095 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_data1101 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_data1107 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_data1112 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_data1117 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_number_in_data1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_align1134 = new BitSet(new long[]{0x0047FFFFFFFFC1C0L,0x0000000000000002L});
    public static final BitSet FOLLOW_number_in_align1136 = new BitSet(new long[]{0x0000000000000002L});

}