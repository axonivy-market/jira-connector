[Ivy]
17CFEC4044ADBB94 9.3.1 #module
>Proto >Proto Collection #zClass
Ks0 KeyInputProcess Big #zClass
Ks0 RD #cInfo
Ks0 #process
Ks0 @AnnotationInP-0n ai ai #zField
Ks0 @TextInP .type .type #zField
Ks0 @TextInP .processKind .processKind #zField
Ks0 @TextInP .xml .xml #zField
Ks0 @TextInP .responsibility .responsibility #zField
Ks0 @UdInit f0 '' #zField
Ks0 @UdProcessEnd f1 '' #zField
Ks0 @PushWFArc f2 '' #zField
Ks0 @UdEvent f3 '' #zField
Ks0 @UdExitEnd f4 '' #zField
Ks0 @PushWFArc f5 '' #zField
>Proto Ks0 Ks0 KeyInputProcess #zField
Ks0 f0 guid 17CFEC40451AD5AD #txt
Ks0 f0 method start() #txt
Ks0 f0 inParameterDecl '<> param;' #txt
Ks0 f0 outParameterDecl '<String key> result;' #txt
Ks0 f0 outParameterMapAction 'result.key=in.key;
' #txt
Ks0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
Ks0 f0 83 51 26 26 -16 15 #rect
Ks0 f1 211 51 26 26 0 12 #rect
Ks0 f2 109 64 211 64 #arcP
Ks0 f3 guid 17CFEC4045A17808 #txt
Ks0 f3 actionTable 'out=in;
' #txt
Ks0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>close</name>
    </language>
</elementInfo>
' #txt
Ks0 f3 83 147 26 26 -15 15 #rect
Ks0 f4 211 147 26 26 0 12 #rect
Ks0 f5 109 160 211 160 #arcP
>Proto Ks0 .type com.axon.market.jira.connector.demo.KeyInput.KeyInputData #txt
>Proto Ks0 .processKind HTML_DIALOG #txt
>Proto Ks0 -8 -8 16 16 16 26 #rect
Ks0 f0 mainOut f2 tail #connect
Ks0 f2 head f1 mainIn #connect
Ks0 f3 mainOut f5 tail #connect
Ks0 f5 head f4 mainIn #connect
