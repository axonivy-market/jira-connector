# Jira Connector

[Atlassian Jira](https://www.atlassian.com/software/jira) is a widely-used project management and issue tracking tool that helps teams efficiently plan, track, and release software. It provides a user-friendly interface for creating tasks, assigning them to team members, setting priorities and deadlines, and monitoring progress.

**Axon Ivy's Atlassian Jira Connector** seamlessly integrates Jira's powerful features into your workflows, allowing you to leverage its capabilities within your processes.

This connector offers:

- Three key functionalities: creating comments, creating issues, and retrieving issues.
- Access to the core API of Atlassian Jira, enabling you to interact with the platform programmatically.
- A demo implementation that minimizes your integration effort, empowering citizen developers to integrate Jira without writing any code.

By utilizing Axon Ivy's Atlassian Jira Connector, you can streamline your project management and issue tracking processes, ensuring smooth collaboration and efficient software development.

## Demo

![jira-connector Demo 1](images/create-issue.png "Create Jira issue")
![jira-connector Demo 2](images/create-comment.png "Craete Jira comment")


## Setup

Open the `Config/variables.yaml` in your Axon Ivy Designer and paste the
code below and adjust the values to your environment.

```
Variables:

  jiraConnector:
  
    # Url to the Jira server
    Url: "https://localhost"

    # Username to connect to the Jira server
    Username: "admin"

    # Password to connect to the Jira server
    Password: "1234"
```
> [!NOTE]
> The variable path `jira-connector` is renamed to `jiraConnector` from 13.