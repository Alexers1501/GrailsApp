<html>
<head>
    <meta name="layout" content="main"/>
    <title>Справочник стран</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Справочник стран</h1>

        <div>
            <p> Всего ${countryTotal} стран в справочнике</p>
            <g:link controller="country" action="add">
                Добавить
            </g:link>
        </div>

        <ul>
            <g:each in="${countryList}" var="country">
                <li>
                    <div class="countryData" id="countryData${country.id}">
                        <h3>${country.name}</h3>
                        столица: ${country.capital}
                        <g:link controller="country" class = "editButton" action="edit" id="${country.id}">
                            Редактировать
                        </g:link>
                        <g:link controller="country" action="delete" id="${country.id}">
                            Удалить
                        </g:link>
                    </div>
                </li>
            </g:each>
        </ul>


%{--        <form action="/country/updateName" method="post" style="margin: 0 auto; width:320px">--}%
%{--            <input type="text" name="name" value="" id="name"/>--}%
%{--            <input type="submit" name="update name" value="update name" id="update name"/>--}%
%{--        </form>--}%
    </section>
</div>

</body>
</html>