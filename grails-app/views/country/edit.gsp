<html>
<head>
    <meta name="layout" content="main"/>
    <title>Справочник стран</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Справочник стран</h1>
        <h2>Реадктирование данных о стране</h2>

        <g:form controller="country" action="updateCountry" method="post"
                params="[countryId: country.id]"
                style="margin: 0 auto; width:320px">
            <label for="name">Название страны</label>
            <input type="text" name="country.name" value="${country.name}" id="name" maxSize="255" required/>

            <label for="capital">Название столицы</label>
            <input type="text" name="country.capital" value="${country.capital}" id="capital" maxSize="128" required/>
            <input type="submit" name="update" value="Сохранить" id="update"/>
        </g:form>
    </section>
</div>

</body>
</html>