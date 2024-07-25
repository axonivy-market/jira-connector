# Jira Konnektor

[Atlassian Jira](https://www.atlassian.com/software/jira) ist ein poluläres Projektmanagement- und Issue-Tracking-Tool, das Teams dabei unterstützt, Software effizient zu planen, zu implementieren und zu veröffentlichen. Es bietet eine benutzerfreundliche Oberfläche zum Erstellen von Aufgaben, die TeamkollegInnen zugewiesen werden können, zum Festlegen von Prioritäten sowie zum Tracken des Fortschritts.

Der **Atlassian Jira Konnektor von Axon Ivy** integriert diese Funktionen in deine Axon Ivy Workflows.

Dieser Konnektor bietet:
- Zugriff auf die Core-API von Atlassian Jira, sodass du per Code mit der Plattform interagieren kannst.
- Drei wesentliche Funktionen: Issues können erstellt, aufgerufen und kommentiert werden.
- Eine Demo-Implementierung, die deinen Integrationsaufwand minimiert und es Citizen Developern ermöglicht, Jira ohne Programmierung zu integrieren.

  
Durch die Nutzung des Atlassian Jira Konnektors von Axon Ivy kannst du deine Projektmanagement- und Issue-Tracking-Prozesse optimieren, eine reibungslose Zusammenarbeit gewährleisten und eine effiziente Softwareentwicklung sicherstellen.

## Demo

![jira-connector Demo 1](images/create-issue.png "Create Jira issue")
![jira-connector Demo 2](images/create-comment.png "Craete Jira comment")


## Setup

Open the `Config/variables.yaml` in your Axon Ivy Designer and paste the
code below and adjust the values to your environment.

```
Variables:

  jira-connector:
  
    # Url to the Jira server
    Url: "https://localhost"

    # Username to connect to the Jira server
    Username: "admin"

    # Password to connect to the Jira server
    Password: "1234"
```

