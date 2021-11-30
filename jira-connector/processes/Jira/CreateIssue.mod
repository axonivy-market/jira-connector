[Ivy]
17CFE812FE1634FD 9.3.1 #module
>Proto >Proto Collection #zClass
Ce0 CreateIssue Big #zClass
Ce0 B #cInfo
Ce0 #process
Ce0 @AnnotationInP-0n ai ai #zField
Ce0 @TextInP .type .type #zField
Ce0 @TextInP .processKind .processKind #zField
Ce0 @TextInP .xml .xml #zField
Ce0 @TextInP .responsibility .responsibility #zField
Ce0 @StartSub f0 '' #zField
Ce0 @EndSub f1 '' #zField
Ce0 @RestClientCall f3 '' #zField
Ce0 @PushWFArc f4 '' #zField
Ce0 @PushWFArc f2 '' #zField
>Proto Ce0 Ce0 CreateIssue #zField
Ce0 f0 inParamDecl '<String projectKey,String issueType,String summary,String description> param;' #txt
Ce0 f0 inParamTable 'out.issueParent.fields.description=param.description;
out.issueParent.fields.issuetype.name=param.issueType;
out.issueParent.fields.project.projKey=param.projectKey;
out.issueParent.fields.summary=param.summary;
' #txt
Ce0 f0 outParamDecl '<com.axonivy.connector.jira.models.IssueParent issueParent> result;' #txt
Ce0 f0 outParamTable 'result.issueParent=in.issueParent;
' #txt
Ce0 f0 callSignature call(String,String,String,String) #txt
Ce0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>call(String,String,String,String)</name>
    </language>
</elementInfo>
' #txt
Ce0 f0 81 49 30 30 -69 17 #rect
Ce0 f1 337 49 30 30 0 15 #rect
Ce0 f3 clientId a5b21baf-2b4f-44ac-a9e7-9c1b0607e0a6 #txt
Ce0 f3 path /issue/ #txt
Ce0 f3 method POST #txt
Ce0 f3 bodyInputType ENTITY #txt
Ce0 f3 bodyObjectType com.axonivy.connector.jira.models.IssueParent #txt
Ce0 f3 bodyObjectMapping 'param=in.issueParent;
' #txt
Ce0 f3 resultType com.axonivy.connector.jira.models.IssueParent #txt
Ce0 f3 responseMapping 'out.issueParent.key=result.key;
' #txt
Ce0 f3 clientErrorCode ivy:error:rest:client #txt
Ce0 f3 statusErrorCode ivy:error:rest:client #txt
Ce0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Create Issue</name>
    </language>
</elementInfo>
' #txt
Ce0 f3 168 42 112 44 -35 -8 #rect
Ce0 f4 111 64 168 64 #arcP
Ce0 f2 280 64 337 64 #arcP
>Proto Ce0 .type com.axonivy.connector.jira.Data #txt
>Proto Ce0 .processKind CALLABLE_SUB #txt
>Proto Ce0 0 0 32 24 18 0 #rect
>Proto Ce0 @|BIcon #fIcon
Ce0 f0 mainOut f4 tail #connect
Ce0 f4 head f3 mainIn #connect
Ce0 f3 mainOut f2 tail #connect
Ce0 f2 head f1 mainIn #connect
