<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="my-styles/main.css"/>

    <g:layoutHead/>
</head>

<body>

<header>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" role="navigation">
        <div class="container-fluid">
            <h2 class="navbar-brand" >Время отдыхать</h2>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" href="/">Поиск</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/country">Страны</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/hotel/catalog">Отели</a>
            </ul>
        </div>
    </nav>

</header>

<g:layoutBody/>

<div class="footer row" role="contentinfo">

</div>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
