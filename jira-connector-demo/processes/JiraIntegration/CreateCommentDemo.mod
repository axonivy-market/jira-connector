[Ivy]
17CFE8EC9A443809 9.3.1 #module
>Proto >Proto Collection #zClass
Co0 CreateCommentDemo Big #zClass
Co0 B #cInfo
Co0 #process
Co0 @AnnotationInP-0n ai ai #zField
Co0 @TextInP .type .type #zField
Co0 @TextInP .processKind .processKind #zField
Co0 @TextInP .xml .xml #zField
Co0 @TextInP .responsibility .responsibility #zField
Co0 @StartRequest f0 '' #zField
Co0 @EndTask f1 '' #zField
Co0 @UserDialog f3 '' #zField
Co0 @PushWFArc f4 '' #zField
Co0 @CallSub f2 '' #zField
Co0 @PushWFArc f5 '' #zField
Co0 @PushWFArc f6 '' #zField
>Proto Co0 Co0 CreateCommentDemo #zField
Co0 f0 outLink start.ivp #txt
Co0 f0 inParamDecl '<> param;' #txt
Co0 f0 requestEnabled true #txt
Co0 f0 triggerEnabled false #txt
Co0 f0 callSignature start() #txt
Co0 f0 startName 'Demo: Create Comment' #txt
Co0 f0 caseData businessCase.attach=true #txt
Co0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
Co0 f0 @C|.responsibility Everybody #txt
Co0 f0 81 49 30 30 -21 17 #rect
Co0 f1 497 49 30 30 0 15 #rect
Co0 f3 dialogId com.axon.market.jira.connector.demo.CreateComment #txt
Co0 f3 startMethod start() #txt
Co0 f3 requestActionDecl '<> param;' #txt
Co0 f3 responseMappingAction 'out=in;
out.comment=result.comment;
out.issueParent.key=result.key;
' #txt
Co0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>CreateComment</name>
    </language>
</elementInfo>
' #txt
Co0 f3 168 42 112 44 -46 -8 #rect
Co0 f4 111 64 168 64 #arcP
Co0 f2 processCall Jira/CreateComment:call(String,String) #txt
Co0 f2 requestActionDecl '<String issueKey,String comment> param;' #txt
Co0 f2 requestMappingAction 'param.issueKey=in.issueParent.key;
param.comment=in.comment;
' #txt
Co0 f2 responseMappingAction 'out=in;
' #txt
Co0 f2 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Jira/CreateComment</name>
    </language>
</elementInfo>
' #txt
Co0 f2 320 42 128 44 -57 -8 #rect
Co0 f2 res:/webContent/icons/jira.png #fDecoratorIcon
Co0 f5 280 64 320 64 #arcP
Co0 f6 448 64 497 64 #arcP
>Proto Co0 .type com.axon.market.jira.connector.demo.Data #txt
>Proto Co0 .processKind NORMAL #txt
>Proto Co0 0 0 32 24 18 0 #rect
>Proto Co0 @|BIcon #fIcon
Co0 f0 mainOut f4 tail #connect
Co0 f4 head f3 mainIn #connect
Co0 f3 mainOut f5 tail #connect
Co0 f5 head f2 mainIn #connect
Co0 f2 mainOut f6 tail #connect
Co0 f6 head f1 mainIn #connect
