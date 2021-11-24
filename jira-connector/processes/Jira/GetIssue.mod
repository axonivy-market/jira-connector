[Ivy]
17CFE858669C1C22 9.3.1 #module
>Proto >Proto Collection #zClass
Ge0 GetIssue Big #zClass
Ge0 B #cInfo
Ge0 #process
Ge0 @AnnotationInP-0n ai ai #zField
Ge0 @TextInP .type .type #zField
Ge0 @TextInP .processKind .processKind #zField
Ge0 @TextInP .xml .xml #zField
Ge0 @TextInP .responsibility .responsibility #zField
Ge0 @StartSub f0 '' #zField
Ge0 @EndSub f1 '' #zField
Ge0 @RestClientCall f3 '' #zField
Ge0 @PushWFArc f4 '' #zField
Ge0 @PushWFArc f2 '' #zField
>Proto Ge0 Ge0 GetIssue #zField
Ge0 f0 inParamDecl '<String issueKey> param;' #txt
Ge0 f0 inParamTable 'out.issueParent.key=param.issueKey;
' #txt
Ge0 f0 outParamDecl '<com.axon.market.jira.connector.models.IssueParent issueParent> result;' #txt
Ge0 f0 outParamTable 'result.issueParent=in.issueParent;
' #txt
Ge0 f0 callSignature call(String) #txt
Ge0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>call(String)</name>
    </language>
</elementInfo>
' #txt
Ge0 f0 81 49 30 30 -13 17 #rect
Ge0 f1 337 49 30 30 0 15 #rect
Ge0 f3 clientId a5b21baf-2b4f-44ac-a9e7-9c1b0607e0a6 #txt
Ge0 f3 path /issue/{key} #txt
Ge0 f3 templateParams 'key=in.issueParent.key;
' #txt
Ge0 f3 resultType com.axon.market.jira.connector.models.IssueParent #txt
Ge0 f3 responseMapping 'out.issueParent=result;
' #txt
Ge0 f3 clientErrorCode ivy:error:rest:client #txt
Ge0 f3 statusErrorCode ivy:error:rest:client #txt
Ge0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Get Issue</name>
    </language>
</elementInfo>
' #txt
Ge0 f3 168 42 112 44 -26 -8 #rect
Ge0 f4 111 64 168 64 #arcP
Ge0 f2 280 64 337 64 #arcP
>Proto Ge0 .type com.axon.market.jira.connector.Data #txt
>Proto Ge0 .processKind CALLABLE_SUB #txt
>Proto Ge0 0 0 32 24 18 0 #rect
>Proto Ge0 @|BIcon #fIcon
Ge0 f0 mainOut f4 tail #connect
Ge0 f4 head f3 mainIn #connect
Ge0 f3 mainOut f2 tail #connect
Ge0 f2 head f1 mainIn #connect
