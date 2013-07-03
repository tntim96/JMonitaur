[#ftl]
<!doctype html>
<html[#if page.properties?keys?seq_contains("ng-app")] ng-app[/#if]>
<head>
    <title>JMonitaur - ${page.title}</title>
    <link rel="stylesheet" href="${rc.getContextPath()}/css/app.css">
    ${page.head}
</head>
<body[#list page.properties?keys as key][#if key?starts_with("body.")] ${key?substring(5)}="${page.properties[key]}"[/#if][/#list]>
<div id="headerdiv">
    <h1>JMonitaur</h1>
</div>
<div id="content" style="margin-top: 50px;">
${page.body}
</div>

<div id="site_footer" style="font-size: 9pt;">
    Footer
</div>
</body>
</html>
