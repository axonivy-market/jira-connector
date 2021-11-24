[Ivy]
17CFE8E82503FAB7 9.3.1 #module
>Proto >Proto Collection #zClass
Co0 CreateIssueDemo Big #zClass
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
Co0 @CallSub f5 '' #zField
Co0 @PushWFArc f6 '' #zField
Co0 @UserDialog f7 '' #zField
Co0 @PushWFArc f8 '' #zField
Co0 @PushWFArc f2 '' #zField
>Proto Co0 Co0 CreateIssueDemo #zField
Co0 f0 outLink start.ivp #txt
Co0 f0 inParamDecl '<> param;' #txt
Co0 f0 requestEnabled true #txt
Co0 f0 triggerEnabled false #txt
Co0 f0 callSignature start() #txt
Co0 f0 startName 'Demo: Create Jira Issue' #txt
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
Co0 f1 657 49 30 30 0 15 #rect
Co0 f3 dialogId com.axon.market.jira.connector.demo.CreateIssue #txt
Co0 f3 startMethod start() #txt
Co0 f3 requestActionDecl '<> param;' #txt
Co0 f3 responseMappingAction 'out=in;
out.issueParent=result.issueParent;
' #txt
Co0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>CreateIssue</name>
    </language>
</elementInfo>
' #txt
Co0 f3 168 42 112 44 -34 -8 #rect
Co0 f4 111 64 168 64 #arcP
Co0 f5 processCall Jira/CreateIssue:call(String,String,String,String) #txt
Co0 f5 requestActionDecl '<String projectKey,String issueType,String summary,String description> param;' #txt
Co0 f5 requestMappingAction 'param.projectKey=in.issueParent.fields.project.projKey;
param.issueType=in.issueParent.fields.issuetype.name;
param.summary=in.issueParent.fields.summary;
param.description=in.issueParent.fields.description;
' #txt
Co0 f5 responseMappingAction 'out=in;
out.issueParent=result.issueParent;
' #txt
Co0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Jira/CreateIssue</name>
    </language>
</elementInfo>
' #txt
Co0 f5 328 42 112 44 -45 -8 #rect
Co0 f5 res:/webContent/icons/jira.png #fDecoratorIcon
Co0 f6 280 64 328 64 #arcP
Co0 f7 dialogId com.axon.market.jira.connector.demo.ShowKey #txt
Co0 f7 startMethod start(String) #txt
Co0 f7 requestActionDecl '<String key> param;' #txt
Co0 f7 requestMappingAction 'param.key=in.issueParent.key;
' #txt
Co0 f7 responseMappingAction 'out=in;
' #txt
Co0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>ShowKey</name>
    </language>
</elementInfo>
' #txt
Co0 f7 496 42 112 44 -25 -8 #rect
Co0 f8 440 64 496 64 #arcP
Co0 f2 608 64 657 64 #arcP
>Proto Co0 .type com.axon.market.jira.connector.demo.Data #txt
>Proto Co0 .processKind NORMAL #txt
>Proto Co0 0 0 32 24 18 0 #rect
>Proto Co0 @|BIcon #fIcon
Co0 f0 mainOut f4 tail #connect
Co0 f4 head f3 mainIn #connect
Co0 f3 mainOut f6 tail #connect
Co0 f6 head f5 mainIn #connect
Co0 f5 mainOut f8 tail #connect
Co0 f8 head f7 mainIn #connect
Co0 f7 mainOut f2 tail #connect
Co0 f2 head f1 mainIn #connect
