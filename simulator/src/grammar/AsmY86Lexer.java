// $ANTLR !Unknown version! grammar/AsmY86.g 2011-08-25 13:22:56

package grammar;

import arch.y86.isa.Assembler;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class AsmY86Lexer extends Lexer {
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__29=29;
    public static final int T__64=64;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__26=26;
    public static final int T__63=63;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int Decimal=8;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
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
    public static final int T__33=33;
    public static final int WS=12;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__70=70;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int Character=9;
    public static final int Hex=7;

    @Override
    public void emitErrorMessage(String msg) {
      throw new Assembler.AssemblyException (msg);
    }


    // delegates
    // delegators

    public AsmY86Lexer() {;} 
    public AsmY86Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AsmY86Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "grammar/AsmY86.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:15:7: ( ':' )
            // grammar/AsmY86.g:15:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:16:7: ( 'halt' )
            // grammar/AsmY86.g:16:9: 'halt'
            {
            match("halt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:17:7: ( 'nop' )
            // grammar/AsmY86.g:17:9: 'nop'
            {
            match("nop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:18:7: ( 'rrmovl' )
            // grammar/AsmY86.g:18:9: 'rrmovl'
            {
            match("rrmovl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:19:7: ( 'cmovle' )
            // grammar/AsmY86.g:19:9: 'cmovle'
            {
            match("cmovle"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:20:7: ( 'cmovl' )
            // grammar/AsmY86.g:20:9: 'cmovl'
            {
            match("cmovl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:21:7: ( 'cmove' )
            // grammar/AsmY86.g:21:9: 'cmove'
            {
            match("cmove"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:22:7: ( 'cmovne' )
            // grammar/AsmY86.g:22:9: 'cmovne'
            {
            match("cmovne"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:23:7: ( 'cmovge' )
            // grammar/AsmY86.g:23:9: 'cmovge'
            {
            match("cmovge"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:24:7: ( 'cmovg' )
            // grammar/AsmY86.g:24:9: 'cmovg'
            {
            match("cmovg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:25:7: ( 'irmovl' )
            // grammar/AsmY86.g:25:9: 'irmovl'
            {
            match("irmovl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:26:7: ( 'rmmovl' )
            // grammar/AsmY86.g:26:9: 'rmmovl'
            {
            match("rmmovl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:27:7: ( 'mrmovl' )
            // grammar/AsmY86.g:27:9: 'mrmovl'
            {
            match("mrmovl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:28:7: ( 'addl' )
            // grammar/AsmY86.g:28:9: 'addl'
            {
            match("addl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:29:7: ( 'subl' )
            // grammar/AsmY86.g:29:9: 'subl'
            {
            match("subl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:30:7: ( 'andl' )
            // grammar/AsmY86.g:30:9: 'andl'
            {
            match("andl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:31:7: ( 'xorl' )
            // grammar/AsmY86.g:31:9: 'xorl'
            {
            match("xorl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:32:7: ( 'mull' )
            // grammar/AsmY86.g:32:9: 'mull'
            {
            match("mull"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:33:7: ( 'divl' )
            // grammar/AsmY86.g:33:9: 'divl'
            {
            match("divl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:34:7: ( 'modl' )
            // grammar/AsmY86.g:34:9: 'modl'
            {
            match("modl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:35:7: ( 'iaddl' )
            // grammar/AsmY86.g:35:9: 'iaddl'
            {
            match("iaddl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:36:7: ( 'isubl' )
            // grammar/AsmY86.g:36:9: 'isubl'
            {
            match("isubl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:37:7: ( 'iandl' )
            // grammar/AsmY86.g:37:9: 'iandl'
            {
            match("iandl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:38:7: ( 'ixorl' )
            // grammar/AsmY86.g:38:9: 'ixorl'
            {
            match("ixorl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:39:7: ( 'imull' )
            // grammar/AsmY86.g:39:9: 'imull'
            {
            match("imull"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:40:7: ( 'idivl' )
            // grammar/AsmY86.g:40:9: 'idivl'
            {
            match("idivl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:41:7: ( 'imodl' )
            // grammar/AsmY86.g:41:9: 'imodl'
            {
            match("imodl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:42:7: ( 'jmp' )
            // grammar/AsmY86.g:42:9: 'jmp'
            {
            match("jmp"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:43:7: ( 'jle' )
            // grammar/AsmY86.g:43:9: 'jle'
            {
            match("jle"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:44:7: ( 'jl' )
            // grammar/AsmY86.g:44:9: 'jl'
            {
            match("jl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:45:7: ( 'je' )
            // grammar/AsmY86.g:45:9: 'je'
            {
            match("je"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:46:7: ( 'jne' )
            // grammar/AsmY86.g:46:9: 'jne'
            {
            match("jne"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:47:7: ( 'jge' )
            // grammar/AsmY86.g:47:9: 'jge'
            {
            match("jge"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:48:7: ( 'jg' )
            // grammar/AsmY86.g:48:9: 'jg'
            {
            match("jg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:49:7: ( 'call' )
            // grammar/AsmY86.g:49:9: 'call'
            {
            match("call"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:50:7: ( 'pushl' )
            // grammar/AsmY86.g:50:9: 'pushl'
            {
            match("pushl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:51:7: ( 'popl' )
            // grammar/AsmY86.g:51:9: 'popl'
            {
            match("popl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:52:7: ( 'leave' )
            // grammar/AsmY86.g:52:9: 'leave'
            {
            match("leave"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:53:7: ( ',' )
            // grammar/AsmY86.g:53:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:54:7: ( '*' )
            // grammar/AsmY86.g:54:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:55:7: ( 'ret' )
            // grammar/AsmY86.g:55:9: 'ret'
            {
            match("ret"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:56:7: ( '$' )
            // grammar/AsmY86.g:56:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:57:7: ( '(' )
            // grammar/AsmY86.g:57:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:58:7: ( ')' )
            // grammar/AsmY86.g:58:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:59:7: ( '%eax' )
            // grammar/AsmY86.g:59:9: '%eax'
            {
            match("%eax"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:60:7: ( '%ecx' )
            // grammar/AsmY86.g:60:9: '%ecx'
            {
            match("%ecx"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:61:7: ( '%edx' )
            // grammar/AsmY86.g:61:9: '%edx'
            {
            match("%edx"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:62:7: ( '%ebx' )
            // grammar/AsmY86.g:62:9: '%ebx'
            {
            match("%ebx"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:63:7: ( '%esp' )
            // grammar/AsmY86.g:63:9: '%esp'
            {
            match("%esp"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:64:7: ( '%ebp' )
            // grammar/AsmY86.g:64:9: '%ebp'
            {
            match("%ebp"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:65:7: ( '%esi' )
            // grammar/AsmY86.g:65:9: '%esi'
            {
            match("%esi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:66:7: ( '%edi' )
            // grammar/AsmY86.g:66:9: '%edi'
            {
            match("%edi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:67:7: ( '-' )
            // grammar/AsmY86.g:67:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:68:7: ( '.pos' )
            // grammar/AsmY86.g:68:9: '.pos'
            {
            match(".pos"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:69:7: ( '.long' )
            // grammar/AsmY86.g:69:9: '.long'
            {
            match(".long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:70:7: ( '.word' )
            // grammar/AsmY86.g:70:9: '.word'
            {
            match(".word"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:71:7: ( '.byte' )
            // grammar/AsmY86.g:71:9: '.byte'
            {
            match(".byte"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:72:7: ( '.align' )
            // grammar/AsmY86.g:72:9: '.align'
            {
            match(".align"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:220:2: ( Character ( Character | Digit )* )
            // grammar/AsmY86.g:220:4: Character ( Character | Digit )*
            {
            mCharacter(); 
            // grammar/AsmY86.g:220:14: ( Character | Digit )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }
                else if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // grammar/AsmY86.g:220:15: Character
            	    {
            	    mCharacter(); 

            	    }
            	    break;
            	case 2 :
            	    // grammar/AsmY86.g:220:27: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "Decimal"
    public final void mDecimal() throws RecognitionException {
        try {
            int _type = Decimal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:221:9: ( ( Digit )+ )
            // grammar/AsmY86.g:221:11: ( Digit )+
            {
            // grammar/AsmY86.g:221:11: ( Digit )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // grammar/AsmY86.g:221:11: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Decimal"

    // $ANTLR start "Hex"
    public final void mHex() throws RecognitionException {
        try {
            int _type = Hex;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:222:5: ( '0' ( 'x' | 'X' ) ( HexDigit )+ )
            // grammar/AsmY86.g:222:7: '0' ( 'x' | 'X' ) ( HexDigit )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // grammar/AsmY86.g:222:21: ( HexDigit )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='F')||(LA3_0>='a' && LA3_0<='f')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // grammar/AsmY86.g:222:21: HexDigit
            	    {
            	    mHexDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Hex"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // grammar/AsmY86.g:224:9: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // grammar/AsmY86.g:224:11: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // grammar/AsmY86.g:226:7: ( ( '0' .. '9' ) )
            // grammar/AsmY86.g:226:9: ( '0' .. '9' )
            {
            // grammar/AsmY86.g:226:9: ( '0' .. '9' )
            // grammar/AsmY86.g:226:10: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "Character"
    public final void mCharacter() throws RecognitionException {
        try {
            // grammar/AsmY86.g:229:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
            // grammar/AsmY86.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Character"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:230:9: ( '#' ( (~ ( '\\n' | '\\r' ) )* NewLine ) )
            // grammar/AsmY86.g:230:11: '#' ( (~ ( '\\n' | '\\r' ) )* NewLine )
            {
            match('#'); 
            // grammar/AsmY86.g:230:15: ( (~ ( '\\n' | '\\r' ) )* NewLine )
            // grammar/AsmY86.g:230:17: (~ ( '\\n' | '\\r' ) )* NewLine
            {
            // grammar/AsmY86.g:230:17: (~ ( '\\n' | '\\r' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // grammar/AsmY86.g:230:17: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            mNewLine(); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comment"

    // $ANTLR start "NewLine"
    public final void mNewLine() throws RecognitionException {
        try {
            int _type = NewLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:231:9: ( ( '\\r' )? '\\n' )
            // grammar/AsmY86.g:231:11: ( '\\r' )? '\\n'
            {
            // grammar/AsmY86.g:231:11: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // grammar/AsmY86.g:231:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NewLine"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // grammar/AsmY86.g:232:6: ( ( ' ' | '\\t' )+ )
            // grammar/AsmY86.g:232:11: ( ' ' | '\\t' )+
            {
            // grammar/AsmY86.g:232:11: ( ' ' | '\\t' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // grammar/AsmY86.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // grammar/AsmY86.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | Identifier | Decimal | Hex | Comment | NewLine | WS )
        int alt7=64;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // grammar/AsmY86.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // grammar/AsmY86.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // grammar/AsmY86.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // grammar/AsmY86.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // grammar/AsmY86.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // grammar/AsmY86.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // grammar/AsmY86.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // grammar/AsmY86.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // grammar/AsmY86.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // grammar/AsmY86.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // grammar/AsmY86.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // grammar/AsmY86.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // grammar/AsmY86.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // grammar/AsmY86.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // grammar/AsmY86.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // grammar/AsmY86.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // grammar/AsmY86.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // grammar/AsmY86.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // grammar/AsmY86.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // grammar/AsmY86.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // grammar/AsmY86.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // grammar/AsmY86.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // grammar/AsmY86.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // grammar/AsmY86.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // grammar/AsmY86.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // grammar/AsmY86.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // grammar/AsmY86.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // grammar/AsmY86.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // grammar/AsmY86.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // grammar/AsmY86.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // grammar/AsmY86.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // grammar/AsmY86.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // grammar/AsmY86.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // grammar/AsmY86.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // grammar/AsmY86.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // grammar/AsmY86.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // grammar/AsmY86.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // grammar/AsmY86.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // grammar/AsmY86.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // grammar/AsmY86.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // grammar/AsmY86.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // grammar/AsmY86.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // grammar/AsmY86.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // grammar/AsmY86.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // grammar/AsmY86.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // grammar/AsmY86.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // grammar/AsmY86.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // grammar/AsmY86.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // grammar/AsmY86.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // grammar/AsmY86.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // grammar/AsmY86.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // grammar/AsmY86.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // grammar/AsmY86.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // grammar/AsmY86.g:1:328: T__66
                {
                mT__66(); 

                }
                break;
            case 55 :
                // grammar/AsmY86.g:1:334: T__67
                {
                mT__67(); 

                }
                break;
            case 56 :
                // grammar/AsmY86.g:1:340: T__68
                {
                mT__68(); 

                }
                break;
            case 57 :
                // grammar/AsmY86.g:1:346: T__69
                {
                mT__69(); 

                }
                break;
            case 58 :
                // grammar/AsmY86.g:1:352: T__70
                {
                mT__70(); 

                }
                break;
            case 59 :
                // grammar/AsmY86.g:1:358: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 60 :
                // grammar/AsmY86.g:1:369: Decimal
                {
                mDecimal(); 

                }
                break;
            case 61 :
                // grammar/AsmY86.g:1:377: Hex
                {
                mHex(); 

                }
                break;
            case 62 :
                // grammar/AsmY86.g:1:381: Comment
                {
                mComment(); 

                }
                break;
            case 63 :
                // grammar/AsmY86.g:1:389: NewLine
                {
                mNewLine(); 

                }
                break;
            case 64 :
                // grammar/AsmY86.g:1:397: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\2\uffff\15\27\11\uffff\1\31\4\uffff\26\27\1\132\1\133\1\27\1\136"+
        "\3\27\7\uffff\1\27\1\150\2\27\1\153\22\27\1\176\1\177\2\uffff\1"+
        "\u0080\1\u0081\1\uffff\3\27\5\uffff\1\u008b\1\uffff\2\27\1\uffff"+
        "\1\27\1\u0092\11\27\1\u009c\1\u009d\1\u009e\1\u009f\1\u00a0\1\u00a1"+
        "\1\u00a2\4\uffff\1\27\1\u00a4\1\27\7\uffff\2\27\1\u00a9\1\u00aa"+
        "\1\27\1\u00ad\1\uffff\1\27\1\u00af\1\u00b0\1\u00b1\1\u00b2\1\u00b3"+
        "\1\u00b4\1\u00b5\1\27\7\uffff\1\u00b7\1\uffff\1\u00b8\1\u00b9\1"+
        "\u00ba\1\u00bb\2\uffff\1\u00bc\1\u00bd\1\uffff\1\u00be\7\uffff\1"+
        "\u00bf\11\uffff";
    static final String DFA7_eofS =
        "\u00c0\uffff";
    static final String DFA7_minS =
        "\1\11\1\uffff\1\141\1\157\1\145\2\141\1\157\1\144\1\165\1\157\1"+
        "\151\1\145\1\157\1\145\5\uffff\1\145\1\uffff\1\141\1\uffff\1\130"+
        "\4\uffff\1\154\1\160\2\155\1\164\1\157\1\154\1\155\1\144\1\165\2"+
        "\157\1\151\1\155\1\154\3\144\1\142\1\162\1\166\1\160\2\60\1\145"+
        "\1\60\1\163\1\160\2\141\6\uffff\1\164\1\60\2\157\1\60\1\166\1\154"+
        "\1\157\2\144\1\142\1\162\1\154\1\144\1\166\1\157\7\154\2\60\2\uffff"+
        "\2\60\1\uffff\1\150\1\154\1\166\2\uffff\1\151\1\160\1\151\1\60\1"+
        "\uffff\2\166\1\uffff\1\145\1\60\1\166\7\154\1\166\7\60\4\uffff\1"+
        "\154\1\60\1\145\7\uffff\2\154\2\60\1\145\1\60\1\uffff\1\154\7\60"+
        "\1\154\7\uffff\1\60\1\uffff\4\60\2\uffff\2\60\1\uffff\1\60\7\uffff"+
        "\1\60\11\uffff";
    static final String DFA7_maxS =
        "\1\172\1\uffff\1\141\1\157\1\162\1\155\1\170\1\165\1\156\1\165\1"+
        "\157\1\151\1\156\1\165\1\145\5\uffff\1\145\1\uffff\1\167\1\uffff"+
        "\1\170\4\uffff\1\154\1\160\2\155\1\164\1\157\1\154\1\155\1\156\1"+
        "\165\1\157\1\165\1\151\1\155\1\154\3\144\1\142\1\162\1\166\1\160"+
        "\2\172\1\145\1\172\1\163\1\160\1\141\1\163\6\uffff\1\164\1\172\2"+
        "\157\1\172\1\166\1\154\1\157\2\144\1\142\1\162\1\154\1\144\1\166"+
        "\1\157\7\154\2\172\2\uffff\2\172\1\uffff\1\150\1\154\1\166\2\uffff"+
        "\2\170\1\160\1\172\1\uffff\2\166\1\uffff\1\156\1\172\1\166\7\154"+
        "\1\166\7\172\4\uffff\1\154\1\172\1\145\7\uffff\2\154\2\172\1\145"+
        "\1\172\1\uffff\1\154\7\172\1\154\7\uffff\1\172\1\uffff\4\172\2\uffff"+
        "\2\172\1\uffff\1\172\7\uffff\1\172\11\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\15\uffff\1\47\1\50\1\52\1\53\1\54\1\uffff\1\65\1\uffff"+
        "\1\73\1\uffff\1\74\1\76\1\77\1\100\36\uffff\1\66\1\67\1\70\1\71"+
        "\1\72\1\75\31\uffff\1\36\1\37\2\uffff\1\42\3\uffff\1\55\1\56\4\uffff"+
        "\1\3\2\uffff\1\51\22\uffff\1\34\1\35\1\40\1\41\3\uffff\1\57\1\64"+
        "\1\60\1\62\1\61\1\63\1\2\6\uffff\1\43\11\uffff\1\22\1\24\1\16\1"+
        "\20\1\17\1\21\1\23\1\uffff\1\45\4\uffff\1\6\1\7\2\uffff\1\12\1\uffff"+
        "\1\25\1\27\1\26\1\30\1\31\1\33\1\32\1\uffff\1\44\1\46\1\4\1\14\1"+
        "\5\1\10\1\11\1\13\1\15";
    static final String DFA7_specialS =
        "\u00c0\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\34\1\33\2\uffff\1\33\22\uffff\1\34\2\uffff\1\32\1\21\1\24"+
            "\2\uffff\1\22\1\23\1\20\1\uffff\1\17\1\25\1\26\1\uffff\1\30"+
            "\11\31\1\1\6\uffff\32\27\4\uffff\1\27\1\uffff\1\10\1\27\1\5"+
            "\1\13\3\27\1\2\1\6\1\14\1\27\1\16\1\7\1\3\1\27\1\15\1\27\1\4"+
            "\1\11\4\27\1\12\2\27",
            "",
            "\1\35",
            "\1\36",
            "\1\41\7\uffff\1\40\4\uffff\1\37",
            "\1\43\13\uffff\1\42",
            "\1\45\2\uffff\1\51\10\uffff\1\50\4\uffff\1\44\1\46\4\uffff"+
            "\1\47",
            "\1\54\2\uffff\1\52\2\uffff\1\53",
            "\1\55\11\uffff\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\64\1\uffff\1\66\4\uffff\1\63\1\62\1\65",
            "\1\70\5\uffff\1\67",
            "\1\71",
            "",
            "",
            "",
            "",
            "",
            "\1\72",
            "",
            "\1\77\1\76\11\uffff\1\74\3\uffff\1\73\6\uffff\1\75",
            "",
            "\1\100\37\uffff\1\100",
            "",
            "",
            "",
            "",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111\11\uffff\1\112",
            "\1\113",
            "\1\114",
            "\1\116\5\uffff\1\115",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27\1\131\25\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\134",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27\1\135\25\27",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142\1\145\1\143\1\144\16\uffff\1\146",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\147",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\151",
            "\1\152",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "",
            "",
            "\1\u0086\16\uffff\1\u0085",
            "\1\u0088\7\uffff\1\u0087",
            "\1\u008a\6\uffff\1\u0089",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\1\u008c",
            "\1\u008d",
            "",
            "\1\u008f\1\uffff\1\u0091\4\uffff\1\u008e\1\uffff\1\u0090",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "",
            "",
            "\1\u00a3",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\u00a5",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27\1\u00a8\25\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\u00ab",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27\1\u00ac\25\27",
            "",
            "\1\u00ae",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\u00b6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | Identifier | Decimal | Hex | Comment | NewLine | WS );";
        }
    }
 

}