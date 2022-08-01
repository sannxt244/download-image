<%-- 
    Document   : statistic
    Created on : Mar 14, 2022, 6:21:46 AM
    Author     : sannx
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistic-Imageram</title>
        <style>
            * {
                margin: 0;
                padding: 0;
            }
            #myChart {
                margin-top: 140px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
        <canvas id="myChart"></canvas>
        <canvas id="myChart1"></canvas>
    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.1/chart.min.js" integrity="sha512-QSkVNOCYLtj73J4hbmVoOV6KVZuMluZlioC+trLpewV8qMjsWqlIQvkn1KGX2StWvPMdWGBqim1xlC8krl1EKQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script>
        const ctx = document.getElementById('myChart').getContext('2d');
        ctx.canvas.width = 600;
        ctx.canvas.height = 300;
        const ctx1 = document.getElementById('myChart1').getContext('2d');
        ctx1.canvas.width = 600;
        ctx1.canvas.height = 300;
        
        var labels = [
        <c:forEach items="${data}" var="item">
            "${item.title}",
        </c:forEach>
        ];
        var data = [
        <c:forEach items="${data}" var="item">
            "${item.amount}",
        </c:forEach>
        ];
        console.log(labels);
        getChart(ctx, labels, data, 'pie');
        getChart(ctx1, labels, data, 'bar');
        function  getChart(canvas, labels, data, chartType) {
            const myChart = new Chart(canvas, {
                type: chartType,
                data: {
                    labels: labels,
                    datasets: [{
                            label: 'Population',
                            data: data,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)'
                            ],
                            borderWidth: 1,
                            borderColor: '#777',
                            hoverBorderWidth: 3,
                            hoverBorderColor: '#000'
                        }]
                },
                options: {
                    responsive: false,
                    maintainAspectRatio: false,
                    title: {
                        display: true,
                        text: 'Largest Cities In Massachusetts',
                        fontSize: 25
                    },
                    legend: {
                        display: false,
                        position: 'right',
                        labels: {
                            fontColor: '#000'
                        }
                    },
                    layout: {
                        padding: {
                            left: 50,
                            right: 0,
                            bottom: 0,
                            top: 0
                        }
                    }
                }
            }
            );
        }

    </script>
</html>
