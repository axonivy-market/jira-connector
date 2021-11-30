[Ivy]
17CFE8EF6BCDA3ED 9.3.1 #module
>Proto >Proto Collection #zClass
Go0 GetIssueDemo Big #zClass
Go0 B #cInfo
Go0 #process
Go0 @AnnotationInP-0n ai ai #zField
Go0 @TextInP .type .type #zField
Go0 @TextInP .processKind .processKind #zField
Go0 @TextInP .xml .xml #zField
Go0 @TextInP .responsibility .responsibility #zField
Go0 @StartRequest f0 '' #zField
Go0 @EndTask f1 '' #zField
Go0 @UserDialog f3 '' #zField
Go0 @PushWFArc f4 '' #zField
Go0 @CallSub f5 '' #zField
Go0 @PushWFArc f6 '' #zField
Go0 @UserDialog f7 '' #zField
Go0 @PushWFArc f8 '' #zField
Go0 @PushWFArc f2 '' #zField
>Proto Go0 Go0 GetIssueDemo #zField
Go0 f0 outLink start.ivp #txt
Go0 f0 inParamDecl '<> param;' #txt
Go0 f0 requestEnabled true #txt
Go0 f0 triggerEnabled false #txt
Go0 f0 callSignature start() #txt
Go0 f0 startName 'Demo: Get Issue' #txt
Go0 f0 caseData businessCase.attach=true #txt
Go0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
Go0 f0 @C|.responsibility Everybody #txt
Go0 f0 81 49 30 30 -21 17 #rect
Go0 f1 657 49 30 30 0 15 #rect
Go0 f3 dialogId com.axonivy.connector.jira.demo.KeyInput #txt
Go0 f3 startMethod start() #txt
Go0 f3 requestActionDecl '<> param;' #txt
Go0 f3 responseMappingAction 'out=in;
out.issueParent.key=result.key;
' #txt
Go0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>KeyInput</name>
    </language>
</elementInfo>
' #txt
Go0 f3 168 42 112 44 -23 -8 #rect
Go0 f4 111 64 168 64 #arcP
Go0 f5 processCall Jira/GetIssue:call(String) #txt
Go0 f5 requestActionDecl '<String issueKey> param;' #txt
Go0 f5 requestMappingAction 'param.issueKey=in.issueParent.key;
' #txt
Go0 f5 responseMappingAction 'out=in;
out.issueParent=result.issueParent;
' #txt
Go0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Jira/GetIssue</name>
    </language>
</elementInfo>
' #txt
Go0 f5 328 42 112 44 -36 -8 #rect
Go0 f5 res:/webContent/icons/jira.png #fDecoratorIcon
Go0 f6 280 64 328 64 #arcP
Go0 f7 dialogId com.axonivy.connector.jira.demo.ShowIssue #txt
Go0 f7 startMethod start(com.axonivy.connector.jira.models.IssueParent) #txt
Go0 f7 requestActionDecl '<com.axonivy.connector.jira.models.IssueParent issueParent> param;' #txt
Go0 f7 requestMappingAction 'param.issueParent=in.issueParent;
' #txt
Go0 f7 responseMappingAction 'out=in;
' #txt
Go0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>ShowIssue</name>
    </language>
</elementInfo>
' #txt
Go0 f7 488 42 112 44 -31 -8 #rect
Go0 f8 440 64 488 64 #arcP
Go0 f2 600 64 657 64 #arcP
>Proto Go0 .type com.axonivy.connector.jira.demo.Data #txt
>Proto Go0 .processKind NORMAL #txt
>Proto Go0 0 0 32 24 18 0 #rect
>Proto Go0 @|BIcon #fIcon
Go0 f0 mainOut f4 tail #connect
Go0 f4 head f3 mainIn #connect
Go0 f3 mainOut f6 tail #connect
Go0 f6 head f5 mainIn #connect
Go0 f5 mainOut f8 tail #connect
Go0 f8 head f7 mainIn #connect
Go0 f7 mainOut f2 tail #connect
Go0 f2 head f1 mainIn #connect
