[Ivy]
17CFEA271DB8776E 9.3.1 #module
>Proto >Proto Collection #zClass
Ss0 ShowKeyProcess Big #zClass
Ss0 RD #cInfo
Ss0 #process
Ss0 @AnnotationInP-0n ai ai #zField
Ss0 @TextInP .type .type #zField
Ss0 @TextInP .processKind .processKind #zField
Ss0 @TextInP .xml .xml #zField
Ss0 @TextInP .responsibility .responsibility #zField
Ss0 @UdInit f0 '' #zField
Ss0 @UdProcessEnd f1 '' #zField
Ss0 @PushWFArc f2 '' #zField
Ss0 @UdEvent f3 '' #zField
Ss0 @UdExitEnd f4 '' #zField
Ss0 @PushWFArc f5 '' #zField
>Proto Ss0 Ss0 ShowKeyProcess #zField
Ss0 f0 guid 17CFEA271DFB81E3 #txt
Ss0 f0 method start(String) #txt
Ss0 f0 inParameterDecl '<String key> param;' #txt
Ss0 f0 inParameterMapAction 'out.key=param.key;
' #txt
Ss0 f0 outParameterDecl '<> result;' #txt
Ss0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start(String)</name>
    </language>
</elementInfo>
' #txt
Ss0 f0 83 51 26 26 -16 15 #rect
Ss0 f1 211 51 26 26 0 12 #rect
Ss0 f2 109 64 211 64 #arcP
Ss0 f3 guid 17CFEA271E484B41 #txt
Ss0 f3 actionTable 'out=in;
' #txt
Ss0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>close</name>
    </language>
</elementInfo>
' #txt
Ss0 f3 83 147 26 26 -15 15 #rect
Ss0 f4 211 147 26 26 0 12 #rect
Ss0 f5 109 160 211 160 #arcP
>Proto Ss0 .type com.axonivy.connector.jira.demo.ShowKey.ShowKeyData #txt
>Proto Ss0 .processKind HTML_DIALOG #txt
>Proto Ss0 -8 -8 16 16 16 26 #rect
Ss0 f0 mainOut f2 tail #connect
Ss0 f2 head f1 mainIn #connect
Ss0 f3 mainOut f5 tail #connect
Ss0 f5 head f4 mainIn #connect
