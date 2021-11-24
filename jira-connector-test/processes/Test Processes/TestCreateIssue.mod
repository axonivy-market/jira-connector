[Ivy]
17D00250FC74B937 9.3.1 #module
>Proto >Proto Collection #zClass
Te0 TestCreateIssue Big #zClass
Te0 B #cInfo
Te0 #process
Te0 @AnnotationInP-0n ai ai #zField
Te0 @TextInP .type .type #zField
Te0 @TextInP .processKind .processKind #zField
Te0 @TextInP .xml .xml #zField
Te0 @TextInP .responsibility .responsibility #zField
Te0 @StartRequest f0 '' #zField
Te0 @EndTask f1 '' #zField
Te0 @GridStep f3 '' #zField
Te0 @PushWFArc f4 '' #zField
Te0 @CallSub f5 '' #zField
Te0 @PushWFArc f6 '' #zField
Te0 @PushWFArc f2 '' #zField
>Proto Te0 Te0 TestCreateIssue #zField
Te0 f0 outLink startCreateIssue.ivp #txt
Te0 f0 inParamDecl '<> param;' #txt
Te0 f0 requestEnabled true #txt
Te0 f0 triggerEnabled false #txt
Te0 f0 callSignature startCreateIssue() #txt
Te0 f0 caseData businessCase.attach=true #txt
Te0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>startCreateIssue.ivp</name>
    </language>
</elementInfo>
' #txt
Te0 f0 @C|.responsibility Everybody #txt
Te0 f0 81 49 30 30 -21 17 #rect
Te0 f1 553 49 30 30 0 15 #rect
Te0 f3 actionTable 'out=in;
' #txt
Te0 f3 actionCode 'import com.axonivy.connector.jira.models.IssueParent;

in.issueParent = new IssueParent();

in.issueParent.fields.project.projKey = "FRXITTEST";
in.issueParent.fields.issuetype.name = "Task";
in.issueParent.fields.summary = "Test summary";
in.issueParent.fields.description = "Test description";' #txt
Te0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Prepare Input of Create Issue call</name>
    </language>
</elementInfo>
' #txt
Te0 f3 152 42 192 44 -91 -8 #rect
Te0 f4 111 64 152 64 #arcP
Te0 f5 processCall Jira/CreateIssue:call(String,String,String,String) #txt
Te0 f5 requestActionDecl '<String projectKey,String issueType,String summary,String description> param;' #txt
Te0 f5 requestMappingAction 'param.projectKey=in.issueParent.fields.project.projKey;
param.issueType=in.issueParent.fields.issuetype.name;
param.summary=in.issueParent.fields.summary;
param.description=in.issueParent.fields.description;
' #txt
Te0 f5 responseMappingAction 'out=in;
out.issueParent=result.issueParent;
' #txt
Te0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Jira/CreateIssue</name>
    </language>
</elementInfo>
' #txt
Te0 f5 384 42 112 44 -45 -8 #rect
Te0 f5 res:/webContent/icons/jira.png #fDecoratorIcon
Te0 f6 344 64 384 64 #arcP
Te0 f2 496 64 553 64 #arcP
>Proto Te0 .type com.axonivy.connector.jira.test.Data #txt
>Proto Te0 .processKind NORMAL #txt
>Proto Te0 0 0 32 24 18 0 #rect
>Proto Te0 @|BIcon #fIcon
Te0 f0 mainOut f4 tail #connect
Te0 f4 head f3 mainIn #connect
Te0 f3 mainOut f6 tail #connect
Te0 f6 head f5 mainIn #connect
Te0 f5 mainOut f2 tail #connect
Te0 f2 head f1 mainIn #connect
