# com.syntereen.templates/app

This repo contains the templates to be used for the syntereen organization.

## Usage


This is a template project for use with [deps-new](https://github.com/seancorfield/deps-new).
As originally generated, it will produce a new library project when run:

    $ clojure -Sdeps '{:deps {com.syntereen/templates {:local/root "syntereen-templates"}}}' -Tnew create :template com.syntereen.templates/lib :name myusername/mycoollib

And a new app project when run:

    $ clojure -Sdeps '{:deps {com.syntereen/templates {:local/root "syntereen-templates"}}}' -Tnew create :template com.syntereen.templates/app :name myusername/mycoolapp

Assuming you have installed `deps-new` as your `new` "tool" via:

```bash
clojure -Ttools install io.github.seancorfield/deps-new '{:git/tag "v0.5.0"}' :as new
```

> Note: once the template has been published (to a public git repo), the invocation will be the same, except the `:local/root` dependency will be replaced by a git or Maven-like coordinate.

Run this template project's tests (by default, this just validates your template's `template.edn`
file -- that it is valid EDN and it satisfies the `deps-new` Spec for template files):

    $ clojure -T:build test

## License

MIT License.
See the LICENSE file for details.
