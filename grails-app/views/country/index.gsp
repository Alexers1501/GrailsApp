<html>
<head>
    <meta name="layout" content="main"/>
    <title>Справочник стран</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">

        <h1>Справочник стран</h1>

        <div class="outer-container">

            <div>
                <g:form controller="country" class="filter-container" action="searchCountry" method="post">
                    <div>
                        <label for="filterName">Поиск</label>
                        <input type="text" name="filterName" value="${filterName}" id="filterName"/>
                    </div>

                    <div>
                        <input type="submit" value="Найти"/>
                    </div>
                </g:form>
            </div>

            <div>
                <p> ${messageCountCountry}</p>
            </div>

            <div>
                <g:link class="button-link" controller="country" action="add">
                    + Добавить страну
                </g:link>
            </div>

            <div class="page-numbers">
                <g:paginate controller="country" action="searchCountry"
                            params="${params}"
                            total="${countryList.totalCount}"/>
            </div>

            <g:if test="${countryList.totalCount > 0}">

                <table>
                    <tr>
                        <th>Название</th>
                        <th>Столица</th>
                        <th>Действия</th>
                    </tr>
                    <g:each in="${countryList}" var="country">
                        <tr>
                            <td>
                                ${country.name}
                            </td>
                            <td>${country.capital}</td>
                            <td>
                                <g:link class="button-link" controller="country" action="edit" id="${country.id}">
                                    Редактировать
                                </g:link>
                                <br>
                                <g:link class="button-link" controller="country" action="delete" id="${country.id}">
                                    Удалить
                                </g:link>
                            </td>
                        </tr>
                    </g:each>
                </table>

            </g:if>

        </div>
    </section>
</div>

</body>
</html>