module.exports = function(grunt) {
  // Do grunt-related things in here
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    clean: {
      build: {
        src: ["public/js/concat.js", "public/js/output.min.js", "public/stylesheets/compiled.css", "public/stylesheets/concat.css", "public/stylesheets/output.min.css"]
      }
    },
    concat: {
      js: {
        src: 'public/js/*.js',
        dest: 'public/js/concat.js'
      },
      css: {
        src: 'public/stylesheets/*.css',
        dest: 'public/stylesheets/concat.css'
      }
    },
    cssmin: {
      combine: {
        files: {
          'public/stylesheets/output.min.css': ['public/stylesheets/compiled.css']
        }
      }
    },
    less: {
      production: {
        options: {
          yuicompress: true
        },
        files: {
          "public/stylesheets/compiled.css": "app/assets/stylesheets/main.less"
        }
      }
    },
    uglify: {
      js: {
        files: {
          'public/js/output.min.js': ['public/js/concat.js']
        }
      }
    },
    jshint: {
      all: ['public/js/emp.js']
    }
  });
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-less');
  grunt.loadNpmTasks('grunt-contrib-uglify');

  grunt.registerTask('default', ['clean', 'jshint', 'concat:js', 'uglify', 'less', 'concat:css', 'cssmin']);
};

