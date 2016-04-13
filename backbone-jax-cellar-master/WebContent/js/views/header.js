window.HeaderView = Backbone.View.extend({

    initialize: function() {
    	console.log('initialize HeaderView ...');
    	// le html de header.html
        this.template = _.template(tpl.get('header'));
    },

    render: function(eventName) {
    	console.log('render HeaderView ...');
    	// ajout au div header le html de header.html
		$(this.el).html(this.template());
		return this;
    },

    events: {
		"click .new"    : "newWine"
    },

	newWine: function(event) {
		app.navigate("wines/new", true);
		return false;
	}

});