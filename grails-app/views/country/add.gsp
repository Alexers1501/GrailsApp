<html>
<head>
    <meta name="layout" content="main"/>
    <title>Справочник стран</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Справочник стран</h1>
        <h2>Добавление страны</h2>

        <g:form controller="country" action="addCountry" method="post"
                style="margin: 0 auto; width:320px">
            <label for="name">Название страны</label>
            <input type="text" name="country.name" value="" id="name"/>

            <label for="capital">Название столицы</label>
            <input type="text" name="country.capital" value="" id="capital"/>
            <input type="submit" name="save" value="Сохранить" id="save"/>
        </g:form>
    </section>
</div>

</body>
</html>