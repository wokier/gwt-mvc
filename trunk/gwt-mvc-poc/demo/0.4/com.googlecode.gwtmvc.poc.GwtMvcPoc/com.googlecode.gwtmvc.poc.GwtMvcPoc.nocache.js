function com_googlecode_gwtmvc_poc_GwtMvcPoc(){var l='',F='" for "gwt:onLoadErrorFn"',D='" for "gwt:onPropertyErrorFn"',n='"><\/script>',p='#',r='/',xb='215E85D00147E9BBFC101EC8A725C97F.cache.html',wb='3B1234E7F31503210DEE4DE001720061.cache.html',vb='4E348D16D5B8FC7CB111AEC4DD0C2775.cache.html',gc='<script defer="defer">com_googlecode_gwtmvc_poc_GwtMvcPoc.onInjectionDone(\'com.googlecode.gwtmvc.poc.GwtMvcPoc\')<\/script>',jc='<script id="',A='=',q='?',ub='AF5850E9F4FD56F8E8A03D71ADC8A280.cache.html',tb='BA736431E7F539ECCC6DDF3F15EAFFD3.cache.html',C='Bad handler "',fc='DOMContentLoaded',zb='F76CB37CBA408EE5521A9AB34F12160C.cache.html',o='SCRIPT',ic='__gwt_marker_com.googlecode.gwtmvc.poc.GwtMvcPoc',s='base',nb='begin',cb='bootstrap',u='clear.cache.gif',m='com.googlecode.gwtmvc.poc.GwtMvcPoc',z='content',cc='css/poc-gwt.css',ec='css/poc-widget.css',bc='css/poc.css',hc='end',mb='gecko',ob='gecko1_8',ac='gwt-log.css',yb='gwt.hybrid',Ab='gwt/chrome/chrome.css',E='gwt:onLoadErrorFn',B='gwt:onPropertyErrorFn',y='gwt:property',Fb='head',rb='hosted.html?com_googlecode_gwtmvc_poc_GwtMvcPoc',Eb='href',lb='ie6',kb='ie8',ab='iframe',t='img',bb="javascript:''",Bb='link',qb='loadExternalRefs',v='meta',eb='moduleRequested',dc='moduleStartup',jb='msie',w='name',gb='opera',db='position:absolute;width:0;height:0;border:none',Cb='rel',ib='safari',sb='selectingPermutation',x='startup',Db='stylesheet',pb='unknown',fb='user.agent',hb='webkit';var lc=window,k=document,kc=lc.__gwtStatsEvent?function(a){return lc.__gwtStatsEvent(a)}:null,Fc,vc,qc,pc=l,yc={},cd=[],Ec=[],oc=[],Bc,Dc;kc&&kc({moduleName:m,subSystem:x,evtGroup:cb,millis:(new Date()).getTime(),type:nb});if(!lc.__gwt_stylesLoaded){lc.__gwt_stylesLoaded={}}if(!lc.__gwt_scriptsLoaded){lc.__gwt_scriptsLoaded={}}function uc(){var b=false;try{b=lc.external&&(lc.external.gwtOnLoad&&lc.location.search.indexOf(yb)==-1)}catch(a){}uc=function(){return b};return b}
function xc(){if(Fc&&vc){var c=k.getElementById(m);var b=c.contentWindow;if(uc()){b.__gwt_getProperty=function(a){return rc(a)}}com_googlecode_gwtmvc_poc_GwtMvcPoc=null;b.gwtOnLoad(Bc,m,pc);kc&&kc({moduleName:m,subSystem:x,evtGroup:dc,millis:(new Date()).getTime(),type:hc})}}
function sc(){var j,h=ic,i;k.write(jc+h+n);i=k.getElementById(h);j=i&&i.previousSibling;while(j&&j.tagName!=o){j=j.previousSibling}function f(b){var a=b.lastIndexOf(p);if(a==-1){a=b.length}var c=b.indexOf(q);if(c==-1){c=b.length}var d=b.lastIndexOf(r,Math.min(c,a));return d>=0?b.substring(0,d+1):l}
;if(j&&j.src){pc=f(j.src)}if(pc==l){var e=k.getElementsByTagName(s);if(e.length>0){pc=e[e.length-1].href}else{pc=f(k.location.href)}}else if(pc.match(/^\w+:\/\//)){}else{var g=k.createElement(t);g.src=pc+u;pc=f(g.src)}if(i){i.parentNode.removeChild(i)}}
function Cc(){var f=document.getElementsByTagName(v);for(var d=0,g=f.length;d<g;++d){var e=f[d],h=e.getAttribute(w),b;if(h){if(h==y){b=e.getAttribute(z);if(b){var i,c=b.indexOf(A);if(c>=0){h=b.substring(0,c);i=b.substring(c+1)}else{h=b;i=l}yc[h]=i}}else if(h==B){b=e.getAttribute(z);if(b){try{Dc=eval(b)}catch(a){alert(C+b+D)}}}else if(h==E){b=e.getAttribute(z);if(b){try{Bc=eval(b)}catch(a){alert(C+b+F)}}}}}}
function bd(d,e){var a=oc;for(var b=0,c=d.length-1;b<c;++b){a=a[d[b]]||(a[d[b]]=[])}a[d[c]]=e}
function rc(d){var e=Ec[d](),b=cd[d];if(e in b){return e}var a=[];for(var c in b){a[b[c]]=c}if(Dc){Dc(d,a,e)}throw null}
var tc;function wc(){if(!tc){tc=true;var a=k.createElement(ab);a.src=bb;a.id=m;a.style.cssText=db;a.tabIndex=-1;k.body.appendChild(a);kc&&kc({moduleName:m,subSystem:x,evtGroup:dc,millis:(new Date()).getTime(),type:eb});a.contentWindow.location.replace(pc+ad)}}
Ec[fb]=function(){var d=navigator.userAgent.toLowerCase();var b=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(d.indexOf(gb)!=-1){return gb}else if(d.indexOf(hb)!=-1){return ib}else if(d.indexOf(jb)!=-1){if(document.documentMode>=8){return kb}else{var c=/msie ([0-9]+)\.([0-9]+)/.exec(d);if(c&&c.length==3){var e=b(c);if(e>=6000){return lb}}}}else if(d.indexOf(mb)!=-1){var c=/rv:([0-9]+)\.([0-9]+)/.exec(d);if(c&&c.length==3){if(b(c)>=1008)return ob}return mb}return pb};cd[fb]={gecko:0,gecko1_8:1,ie6:2,ie8:3,opera:4,safari:5};com_googlecode_gwtmvc_poc_GwtMvcPoc.onScriptLoad=function(){if(tc){vc=true;xc()}};com_googlecode_gwtmvc_poc_GwtMvcPoc.onInjectionDone=function(){Fc=true;kc&&kc({moduleName:m,subSystem:x,evtGroup:qb,millis:(new Date()).getTime(),type:hc});xc()};sc();var ad;if(uc()){if(lc.external.initModule&&lc.external.initModule(m)){lc.location.reload();return}ad=rb}Cc();kc&&kc({moduleName:m,subSystem:x,evtGroup:cb,millis:(new Date()).getTime(),type:sb});if(!ad){try{bd([ib],tb);bd([gb],ub);bd([ob],vb);bd([mb],wb);bd([kb],xb);bd([lb],zb);ad=oc[rc(fb)]}catch(a){return}}var Ac;function zc(){if(!qc){qc=true;if(!__gwt_stylesLoaded[Ab]){var a=k.createElement(Bb);__gwt_stylesLoaded[Ab]=a;a.setAttribute(Cb,Db);a.setAttribute(Eb,pc+Ab);k.getElementsByTagName(Fb)[0].appendChild(a)}if(!__gwt_stylesLoaded[ac]){var a=k.createElement(Bb);__gwt_stylesLoaded[ac]=a;a.setAttribute(Cb,Db);a.setAttribute(Eb,pc+ac);k.getElementsByTagName(Fb)[0].appendChild(a)}if(!__gwt_stylesLoaded[bc]){var a=k.createElement(Bb);__gwt_stylesLoaded[bc]=a;a.setAttribute(Cb,Db);a.setAttribute(Eb,pc+bc);k.getElementsByTagName(Fb)[0].appendChild(a)}if(!__gwt_stylesLoaded[cc]){var a=k.createElement(Bb);__gwt_stylesLoaded[cc]=a;a.setAttribute(Cb,Db);a.setAttribute(Eb,pc+cc);k.getElementsByTagName(Fb)[0].appendChild(a)}if(!__gwt_stylesLoaded[ec]){var a=k.createElement(Bb);__gwt_stylesLoaded[ec]=a;a.setAttribute(Cb,Db);a.setAttribute(Eb,pc+ec);k.getElementsByTagName(Fb)[0].appendChild(a)}xc();if(k.removeEventListener){k.removeEventListener(fc,zc,false)}if(Ac){clearInterval(Ac)}}}
if(k.addEventListener){k.addEventListener(fc,function(){wc();zc()},false)}var Ac=setInterval(function(){if(/loaded|complete/.test(k.readyState)){wc();zc()}},50);kc&&kc({moduleName:m,subSystem:x,evtGroup:cb,millis:(new Date()).getTime(),type:hc});kc&&kc({moduleName:m,subSystem:x,evtGroup:qb,millis:(new Date()).getTime(),type:nb});k.write(gc)}
com_googlecode_gwtmvc_poc_GwtMvcPoc();