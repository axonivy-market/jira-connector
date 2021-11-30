[Ivy]
17CFE8F33D99A7D1 9.3.1 #module
>Proto >Proto Collection #zClass
Io0 IssueUpdatedDemo Big #zClass
Io0 B #cInfo
Io0 #process
Io0 @AnnotationInP-0n ai ai #zField
Io0 @TextInP .type .type #zField
Io0 @TextInP .processKind .processKind #zField
Io0 @TextInP .xml .xml #zField
Io0 @TextInP .responsibility .responsibility #zField
Io0 @StartRequest f0 '' #zField
Io0 @EndTask f1 '' #zField
Io0 @CallSub f3 '' #zField
Io0 @PushWFArc f4 '' #zField
Io0 @UserTask f5 '' #zField
Io0 @TkArc f6 '' #zField
Io0 @PushWFArc f2 '' #zField
>Proto Io0 Io0 IssueUpdatedDemo #zField
Io0 f0 outLink start.ivp #txt
Io0 f0 inParamDecl '<String key> param;' #txt
Io0 f0 inParamTable 'out.issueParent.key=param.key;
' #txt
Io0 f0 requestEnabled true #txt
Io0 f0 triggerEnabled false #txt
Io0 f0 callSignature start(String) #txt
Io0 f0 startName 'Demo: Issue updated' #txt
Io0 f0 caseData businessCase.attach=true #txt
Io0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
Io0 f0 @C|.responsibility Everybody #txt
Io0 f0 81 49 30 30 -21 17 #rect
Io0 f1 497 49 30 30 0 15 #rect
Io0 f3 processCall Jira/GetIssue:call(String) #txt
Io0 f3 requestActionDecl '<String issueKey> param;' #txt
Io0 f3 requestMappingAction 'param.issueKey=in.issueParent.key;
' #txt
Io0 f3 responseMappingAction 'out=in;
out.issueParent=result.issueParent;
' #txt
Io0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Jira/GetIssue</name>
    </language>
</elementInfo>
' #txt
Io0 f3 168 42 112 44 -36 -8 #rect
Io0 f3 res:/webContent/icons/jira.png #fDecoratorIcon
Io0 f4 111 64 168 64 #arcP
Io0 f5 dialogId com.axonivy.connector.jira.demo.ShowIssue #txt
Io0 f5 startMethod start(com.axonivy.connector.jira.models.IssueParent) #txt
Io0 f5 requestActionDecl '<com.axonivy.connector.jira.models.IssueParent issueParent> param;' #txt
Io0 f5 requestMappingAction 'param.issueParent=in.issueParent;
' #txt
Io0 f5 responseMappingAction 'out=in;
' #txt
Io0 f5 caseData 'case.name=Jira issue updated' #txt
Io0 f5 taskData 'TaskA.NAM=Jira issue updated
TaskA.ROL=in.issueParent.fields.reporter.key
TaskA.TYPE=3' #txt
Io0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>ShowIssue</name>
    </language>
</elementInfo>
' #txt
Io0 f5 328 42 112 44 -31 -8 #rect
Io0 f6 280 64 328 64 #arcP
Io0 f2 440 64 497 64 #arcP
>Proto Io0 .type com.axonivy.connector.jira.demo.Data #txt
>Proto Io0 .processKind NORMAL #txt
>Proto Io0 0 0 32 24 18 0 #rect
>Proto Io0 @|BIcon #fIcon
Io0 f0 mainOut f4 tail #connect
Io0 f4 head f3 mainIn #connect
Io0 f3 mainOut f6 tail #connect
Io0 f6 head f5 in #connect
Io0 f5 out f2 tail #connect
Io0 f2 head f1 mainIn #connect
