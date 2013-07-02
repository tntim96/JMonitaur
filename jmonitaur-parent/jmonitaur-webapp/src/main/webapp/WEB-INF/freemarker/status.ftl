[#ftl]
<html>
<head>
    <title>Status</title>
</head>
<body>
<table class="healthTable">
    <tr>
        <th>Level</th>
        <th>System</th>
        <th>Description</th>
    </tr>
[#list statuses as status]
    <tr>
        <td>${status.level.name()}</td>
        <td>${status.systemId}</td>
        <td>${status.description}</td>
    </tr>
[/#list]
</table>
</body>
</html>