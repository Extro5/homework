<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<t:main_layout title="Good new idea">
    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <hr>
                <h2 class="intro-text text-center">Build a website
                    <strong>worth visiting</strong>
                </h2>
                <hr>
                <img class="img-responsive img-border img-left"
                     src="<c:url value="/img/intro-pic.jpg"/>"
                     alt="">
                <hr class="visible-xs">
                <p>The boxes used in this template are nested inbetween a normal Bootstrap row and the start of your
                    column layout. The boxes will be full-width boxes, so if you want to make them smaller then you
                    will
                    need to customize.</p>
                <p>A huge thanks to allowing us to use the beautiful photos that make this template really come to
                    life.
                    When using this template, make sure your photos are decent. Also make sure that the file size on
                    your photos is kept to a minumum to keep load times to a minimum.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum
                    dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in
                    faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis
                    egestas.</p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <hr>
                <h2 class="intro-text text-center">Beautiful boxes
                    <strong>to showcase your content</strong>
                </h2>
                <hr>
                <p>Use as many boxes as you like, and put anything you want in them! They are great for just about
                    anything, the sky's the limit!</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum
                    dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in
                    faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis
                    egestas.</p>
            </div>
        </div>
    </div>
</t:main_layout>