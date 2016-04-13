window.WineListView = Backbone.View.extend({

    tagName:'ul',

    initialize:function () {
    	console.log('initialize WineListView ...');
        this.model.bind("reset", this.render, this);
        var self = this;
        this.model.bind("add", function (wine) {
            $(self.el).append(new WineListItemView({model:wine}).render().el);
        });
    },

    render:function (eventName) {
    	console.log('render WineListView ...');
        _.each(this.model.models, function (wine) {
            $(this.el).append(new WineListItemView({model:wine}).render().el);
        }, this);
        return this;
    }
});

window.WineListItemView = Backbone.View.extend({

    tagName:"li",

    initialize:function () {
    	console.log('initialize WineListItemView ...');
        this.template = _.template(tpl.get('wine-list-item'));
        this.model.bind("change", this.render, this);
        this.model.bind("destroy", this.close, this);
    },

    render:function (eventName) {
    	console.log('render WineListItemView ...');
    	// modif GGA 20150507
    	var jsonModel = this.model.toJSON();
        $(this.el).html(this.template(jsonModel));
        console.log('model id : ' + jsonModel.id + ' and name ' + jsonModel.name);
        return this;
    }

});