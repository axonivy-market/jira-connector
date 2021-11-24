[Ivy]
17CFE7FDBE643EEE 9.3.1 #module
>Proto >Proto Collection #zClass
Ct0 CreateComment Big #zClass
Ct0 B #cInfo
Ct0 #process
Ct0 @AnnotationInP-0n ai ai #zField
Ct0 @TextInP .type .type #zField
Ct0 @TextInP .processKind .processKind #zField
Ct0 @TextInP .xml .xml #zField
Ct0 @TextInP .responsibility .responsibility #zField
Ct0 @StartSub f0 '' #zField
Ct0 @EndSub f1 '' #zField
Ct0 @RestClientCall f3 '' #zField
Ct0 @PushWFArc f4 '' #zField
Ct0 @PushWFArc f2 '' #zField
>Proto Ct0 Ct0 CreateComment #zField
Ct0 f0 inParamDecl '<String issueKey,String comment> param;' #txt
Ct0 f0 inParamTable 'out.comment=param.comment;
out.issueParent.key=param.issueKey;
' #txt
Ct0 f0 outParamDecl '<> result;' #txt
Ct0 f0 callSignature call(String,String) #txt
Ct0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>call(String,String)</name>
    </language>
</elementInfo>
' #txt
Ct0 f0 81 49 30 30 -39 18 #rect
Ct0 f1 337 49 30 30 0 15 #rect
Ct0 f3 clientId a5b21baf-2b4f-44ac-a9e7-9c1b0607e0a6 #txt
Ct0 f3 path issue/{key}/comment #txt
Ct0 f3 templateParams 'key=in.issueParent.key;
' #txt
Ct0 f3 method POST #txt
Ct0 f3 bodyInputType ENTITY #txt
Ct0 f3 bodyObjectType com.axon.market.jira.connector.models.Comment #txt
Ct0 f3 bodyObjectMapping 'param.body=in.comment;
' #txt
Ct0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Create Comment</name>
    </language>
</elementInfo>
' #txt
Ct0 f3 168 42 112 44 -47 -8 #rect
Ct0 f4 111 64 168 64 #arcP
Ct0 f2 280 64 337 64 #arcP
>Proto Ct0 .type com.axon.market.jira.connector.Data #txt
>Proto Ct0 .processKind CALLABLE_SUB #txt
>Proto Ct0 0 0 32 24 18 0 #rect
>Proto Ct0 @|BIcon #fIcon
Ct0 f0 mainOut f4 tail #connect
Ct0 f4 head f3 mainIn #connect
Ct0 f3 mainOut f2 tail #connect
Ct0 f2 head f1 mainIn #connect
